ENV_VAR = "PREFIX=${D}/usr PKGDIR=${S} \
	CROSS=${AR%-*}- \
	BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
	OMX_PERF_INSTRUMENTATION=1 OMX_PERF_CUSTOMIZABLE=1 \
	RAPARSERINCLUDEDIR=${STAGING_INCDIR}/omx RVPARSERINCLUDEDIR=${STAGING_INCDIR}/omx \
	"

inherit pkgconfig

do_compile() {
	oe_runmake ${ENV_VAR} \
		TARGETDIR=${STAGING_DIR_TARGET}/usr OMXROOT=${S} \
		SYSTEMINCLUDEDIR=${STAGING_INCDIR}/omx \ 
		${OMX_COMPONENT}
}

do_install() {
	install -d ${D}/usr/lib
	install -d ${D}/usr/bin
	install -d ${D}/usr/omx/patterns
	oe_runmake ${ENV_VAR} \
		TARGETDIR=${D}/usr OMXTESTDIR=${D}/usr/bin OMXROOT=${S} \
		SYSTEMINCLUDEDIR=${D}/include/omx \
		${OMX_COMPONENT}.install
}

do_stage() {
	# Somehow, ${STAGING_DIR}/${HOST_SYS} != ${STAGING_LIBDIR}/../
	#STAGE_DIR=${STAGING_LIBDIR}/../

	oe_runmake ${ENV_VAR} \
		TARGETDIR=${STAGING_DIR_TARGET}/usr OMXROOT=${S} \
		SYSTEMINCLUDEDIR=${STAGING_INCDIR}/omx \
		${OMX_COMPONENT}.install
}

FILES_${PN} = "\
	/usr \
	/usr/lib \
	/usr/bin \
	"

FILES_${PN}-patterns = "\
	/usr/omx/patterns \
	"

FILES_${PN}-dbg = "\
	/usr/.debug \
	/usr/bin/.debug \
	/usr/lib/.debug \
	/usr/omx/.debug \
	"

FILES_${PN}-dev = "\
	/usr/include \
	"
