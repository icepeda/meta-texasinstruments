DESCRIPTION = "Texas Instruments OpenMAX IL Linux Common Media Library."
PR = "r1"
DEPENDS = "tidspbridge-lib tiopenmax-core"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/system/src/openmax_il/lcml \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "lcml"

inherit tiopenmax ccasefetch

SRC_URI = "file://lcmlnocore.patch;patch=1"
