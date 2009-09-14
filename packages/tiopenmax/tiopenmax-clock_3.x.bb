DESCRIPTION = "Texas Instruments OpenMAX IL Clock."
PR = "r1"
DEPENDS = "tidspbridge-lib tiopenmax-core"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/system/src/openmax_il/clock_source \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "clock"

inherit tiopenmax ccasefetch

SRC_URI = "file://clocknocore.patch;patch=1"
