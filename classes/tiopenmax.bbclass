ENV_VAR = "PREFIX=${D} PKGDIR=${S} \
	CROSS=${AR%-*}- \
	BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
	OMX_PERF_INSTRUMENTATION=1 OMX_PERF_CUSTOMIZABLE=1 \
	RAPARSERINCLUDEDIR=${STAGING_INCDIR}/omx RVPARSERINCLUDEDIR=${STAGING_INCDIR}/omx \
	"

do_compile() {
	oe_runmake ${ENV_VAR} \
		TARGETDIR=${STAGING_INCDIR}/../ OMXROOT=${S} \
		${OMX_COMPONENT}
}

do_install() {
	install -d ${D}/omx
	install -d ${D}/lib
	install -d ${D}/bin
	oe_runmake ${ENV_VAR} \
		TARGETDIR=${D} OMXROOT=${S} \
		SYSTEMINCLUDEDIR=${D}/include/omx \
		${OMX_COMPONENT}.install
}

do_stage() {
	# Somehow, ${STAGING_DIR}/${HOST_SYS} != ${STAGING_LIBDIR}/../
	STAGE_DIR=${STAGING_LIBDIR}/../

	oe_runmake ${ENV_VAR} \
		TARGETDIR=${STAGING_INCDIR}/../ OMXROOT=${S} \
		SYSTEMINCLUDEDIR=${STAGING_INCDIR}/omx \
		${OMX_COMPONENT}.install
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
