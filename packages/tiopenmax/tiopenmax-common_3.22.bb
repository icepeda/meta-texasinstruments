DESCRIPTION = "Texas Instruments OpenMAX IL Common."
PR = "r1"
DEPENDS = "tidspbridge-lib"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/system/src/openmax_il/common \
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/aac_dec/inc/TIDspOmx.h \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "common"

inherit tiopenmax ccasefetch

do_compile_prepend() {
	cp ${S}/audio/src/openmax_il/aac_dec/inc/TIDspOmx.h ${STAGING_INCDIR}/omx
}
