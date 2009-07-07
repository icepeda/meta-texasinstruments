ENV_VAR = "\
	PREFIX=${D}/usr PKGDIR=${S} \
	CROSS=${AR%-*}- \
	BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
	OMX_PERF_INSTRUMENTATION=1 OMX_PERF_CUSTOMIZABLE=1 \
	RAPARSERINCLUDEDIR=${STAGING_INCDIR}/omx RVPARSERINCLUDEDIR=${STAGING_INCDIR}/omx \
	"

inherit pkgconfig

do_compile() {
	STAGING_TARGETDIR=${STAGING_INCDIR}/../../
	oe_runmake ${ENV_VAR} \
		TARGETDIR=${STAGING_TARGETDIR}/usr OMXTESTDIR=${STAGING_TARGETDIR}/usr/bin OMXROOT=${S} \
		OMXINCLUDEDIR=${STAGING_INCDIR}/omx SYSTEMINCLUDEDIR=${STAGING_INCDIR}/omx \
		${OMX_COMPONENT}
}

do_install() {
	install -d ${D}/usr/lib
	install -d ${D}/usr/bin
	install -d ${D}/usr/omx
	oe_runmake ${ENV_VAR} \
		TARGETDIR=${D}/usr OMXTESTDIR=${D}/usr/bin OMXROOT=${S} \
		OMXINCLUDEDIR=${D}/usr/include/omx SYSTEMINCLUDEDIR=${D}/usr/include/omx \
		${OMX_COMPONENT}.install
}

do_stage() {
	STAGING_TARGETDIR=${STAGING_INCDIR}/../../
	oe_runmake ${ENV_VAR} \
		TARGETDIR=${STAGING_TARGETDIR}/usr OMXTESTDIR=${STAGING_TARGETDIR}/usr/bin OMXROOT=${S} \
		OMXINCLUDEDIR=${STAGING_INCDIR}/omx SYSTEMINCLUDEDIR=${STAGING_INCDIR}/omx \
		${OMX_COMPONENT}.install
}

FILES_${PN} = "\
	/usr \
	/usr/lib \
	/usr/bin \
	"

FILES_${PN}-dbg = "\
	/usr/bin/.debug \
	/usr/lib/.debug \
	"

FILES_${PN}-dev = "\
	/usr/include \
	"

FILES_${PN}-ptrns = "\
	/usr/omx \
	"
