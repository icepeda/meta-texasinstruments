DESCRIPTION = "Texas Instruments OpenMAX IL Resource Activity Monitor."
PR = "r1"
DEPENDS = "tidspbridge-lib tiopenmax-core"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/system/src/openmax_il/resource_manager/resource_activity_monitor \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "resource_activity_monitor"

inherit tiopenmax ccasefetch

SRC_URI = "file://ramnocore.patch;patch=1 \
		"
