DEPENDS = "tidspbridge-lib mm-isp ${TTIF_DEPENDS}"
DESCRIPTION = "Texas Instruments OpenMAX IL."
PR = "r0${TTIF_PR}"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-patterns ${PN}"

PROVIDES = "virtual/openmax-il"
RPROVIDES = "virtual/openmax-il"

require tiopenmax-cspec-${PV}.inc

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_MPU/linux"
CCASE_PATHCOMPONENTS = 3
CCASE_PATHCOMPONENT = "linux"


inherit pkgconfig ccasefetch

SRC_URI = "\
	file://23.14-aacdecnocore.patch;patch=1 \
	file://23.14-aacdectestnocore.patch;patch=1 \
	file://23.14-aacencnocore.patch;patch=1 \
  	file://23.14-aacenctestnocore.patch;patch=1 \
	file://23.14-g711decnocore.patch;patch=1 \
	file://23.14-g711decnoincinstall.patch;patch=1 \
	file://23.13-g711encnocore.patch;patch=1 \
	file://23.13-g711encnoincinstall.patch;patch=1 \
	file://23.14-gsmfrdecnocore.patch;patch=1 \
	file://23.14-gsmfrdectestnocore.patch;patch=1 \
	file://23.14-gsmfrencnocore.patch;patch=1 \
	file://23.14-gsmfrenctestnocore.patch;patch=1 \
	file://23.14-gsmhrdecnocore.patch;patch=1 \
	file://23.14-gsmhrdectestnocore.patch;patch=1 \
	file://23.14-gsmhrencnocore.patch;patch=1 \
	file://23.14-gsmhrenctestnocore.patch;patch=1 \
	file://23.14-imaadpcmdecnocore.patch;patch=1 \
	file://23.14-imaadpcmdectestnocore.patch;patch=1 \
	file://23.14-imaadpcmencnocore.patch;patch=1 \
	file://23.14-imaadpcmenctestnocore.patch;patch=1 \
	file://23.14-imaadpcmencmkfile.patch;patch=1 \	
	file://23.17P1-imaadpcmencmktest.patch;patch=1 \
	file://23.14-imaadpcmencmsttest.patch;patch=1 \
	file://23.14-mp3decnocore.patch;patch=1 \
	file://23.14-mp3decnoincinstall.patch;patch=1 \
	file://23.14-nbamrdecnocore.patch;patch=1 \
	file://23.14-nbamrdectestnocore.patch;patch=1 \
	file://23.14-nbamrencnocore.patch;patch=1 \
	file://23.14-nbamrenctestnocore.patch;patch=1 \
	file://23.14-pcmdecnocore.patch;patch=1 \
	file://23.14-pcmdectestnocore.patch;patch=1 \
	file://23.14-pcmencnocore.patch;patch=1 \
	file://23.14-pcmenctestnocore.patch;patch=1 \
	file://23.14-wbamrdecnocore.patch;patch=1 \
	file://23.14-wbamrdectestnocore.patch;patch=1 \
	file://23.14-wbamrencnocore.patch;patch=1 \
	file://23.14-wbamrenctestnocore.patch;patch=1 \
	file://23.14-wmadecnocore.patch;patch=1 \
	file://23.14-wmadectestnocore.patch;patch=1 \
	${@base_contains("DISTRO_FEATURES", "testpatterns", "", "file://remove-patterns.patch;patch=1", d)} \
	"

SRC_URI += " ${@base_contains("DISTRO_FEATURES", "ttif", "file://ttif.patch;patch=1", "", d)} "


do_compile_prepend() {
	install -m 0644 ${FILESDIR}/omap24xxvout.h ${S}/video/src/openmax_il/post_processor/inc/omap24xxvout.h
	install -m 0644 ${FILESDIR}/libomxil-ti.pc ${S}/libomxil.pc
	install -d ${D}/omx
	
	rm -rf ${HOME}/Documents/Klockworks/*
}

do_compile() {
	kwinject --config /data/apps/kw-server/config/kwfilter.conf -T ${HOME}/Documents/Klockworks/Audio_TRACE.tpl make \
		PREFIX=${D}/usr PKGDIR=${S} \
		CROSS=${AR%-*}- \
		BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
		TARGETDIR=${D}/usr OMXTESTDIR=${D}${bindir} OMXROOT=${S} OMXLIBDIR=${STAGING_LIBDIR} \
        OMX_PERF_INSTRUMENTATION=1 OMX_PERF_CUSTOMIZABLE=1 \
        OMXINCLUDEDIR=${STAGING_INCDIR}/omx \
		aac_dec aac_dec_ittiam aac_enc g711_dec g711_enc gsmfr_dec gsmfr_enc gsmhr_dec gsmhr_enc imaadpcm_dec imaadpcm_enc mp3_dec \
		nbamr_dec nbamr_enc pcm_dec pcm_enc wbamr_dec wbamr_enc wma_dec
	kwinject --config /data/apps/kw-server/config/kwfilter.conf -t ${HOME}/Documents/Klockworks/Audio_TRACE.tpl \
		-o ${HOME}/Documents/Klockworks/Audio_BSPEC.tpl
	kwbuildproject ${HOME}/Documents/Klockworks/Audio_BSPEC.tpl --tables-directory ${HOME}/Documents/Klockworks/Audio_TABLES \
		--license-host flames-usa4.sc.ti.com --license-port 27005
#	kwadmin --host klocwork01.dal.design.ti.com --port 1116 delete-build WS_3630_OMX_Audio_Linux_23_Inc3 3630_OMX_Audio_Linux_23_Inc3_7
	kwadmin --host klocwork01.dal.design.ti.com --port 1116 --verbose load WS_3630_OMX_Audio_Linux_23_Inc3 \
		${HOME}/Documents/Klockworks/Audio_TABLES --copy-sources --name 3630_OMX_Audio_Linux_23_Inc3_7
}

FILES_${PN} = "\
	/lib \
	/bin \
	/omx \
	/inst2 \
	"

FILES_${PN}-patterns = "\
	/omx/patterns \
	"

FILES_${PN}-dbg = "\
	/omx/.debug \
	/bin/.debug \
	/lib/.debug \
	/inst2/.debug \
	"

FILES_${PN}-dev = "\
	/include \
	"
