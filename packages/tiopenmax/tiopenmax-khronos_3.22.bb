DESCRIPTION = "Texas Instruments OpenMAX IL Khronos."
PR = "r1"
DEPENDS = ""
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/system/src/openmax_il/khronos \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "all"

inherit ccasefetch

#SRC_URI = "file://khronosfix.patch;patch=1"

do_compile() {
	cd ${S}/system/src/openmax_il/khronos
	install -d ${D}/omx
	install -d ${D}/lib
	install -d ${D}/bin
	oe_runmake PREFIX=${D} PKGDIR=${STAGING_INCDIR} \
		CROSS=${AR%-*}- \
		BRIDGEINCLUDEDIR=${STAGING_INCDIR}/dspbridge BRIDGELIBDIR=${STAGING_LIBDIR} \
		TARGETDIR=${STAGING_INCDIR}/../ OMXROOT=${S} \
		${OMX_COMPONENT}
}
