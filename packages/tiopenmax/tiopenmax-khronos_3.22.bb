DESCRIPTION = "Texas Instruments OpenMAX IL Khronos."
PR = "r1"
DEPENDS = "tiopenmax-aacdec tiopenmax-aacenc tiopenmax-g711dec tiopenmax-g711enc tiopenmax-g729dec tiopenmax-g729enc tiopenmax-mp3dec \
	tiopenmax-nbamrdec tiopenmax-nbamrenc tiopenmax-pcmdec tiopenmax-pcmenc tiopenmax-wbamrdec tiopenmax-wbamrenc tiopenmax-wmadec \
	tiopenmax-rageckodec"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/system/src/openmax_il/khronos \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "all"

inherit pkgconfig ccasefetch

SRC_URI = "file://khronosfix.patch;patch=1"

do_compile_prepend() {
	cd ${S}/system/src/openmax_il/khronos
	cp -f ${STAGING_INCDIR}/omx/OMX_* headers
}

do_compile() {
	make PREFIX=${D} PKGDIR=${STAGING_INCDIR}/../ \
		CROSS=${AR%-*}- \
		BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
		${OMX_COMPONENT}
}

do_install() {
	install -d ${D}/omx
	install -d ${D}/bin
	install -d ${D}/lib
	cd ${S}/system/src/openmax_il/khronos
        make PREFIX=${D} PKGDIR=${D}/ \
		CROSS=${AR%-*}- \
		BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
		${OMX_COMPONENT}
}

FILES_${PN} = "\
	/lib \
	/bin \
	/omx \
	"

FILES_${PN}-dbg = "\
	/omx/.debug \
	/bin/.debug \
	/lib/.debug \
	"

FILES_${PN}-dev = "\
	/include \
	"
