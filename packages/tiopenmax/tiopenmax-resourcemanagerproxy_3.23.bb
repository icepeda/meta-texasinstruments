DESCRIPTION = "Texas Instruments OpenMAX IL Resource Manager Proxy."
PR = "r1"
DEPENDS = "tidspbridge-lib tiopenmax-core"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/system/src/openmax_il/resource_manager_proxy \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "resource_manager_proxy"

inherit tiopenmax ccasefetch
