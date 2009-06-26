DESCRIPTION = "Texas Instruments OpenMAX IL Resource Manager."
PR = "r1"
DEPENDS = "tidspbridge-lib tiopenmax-core tiopenmax-policymanager"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/system/src/openmax_il/resource_manager \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "resource_manager"

inherit tiopenmax ccasefetch

SRC_URI = "file://rmmakenocore.patch;patch=1 \
	   file://ramnocore.patch;patch=1"

