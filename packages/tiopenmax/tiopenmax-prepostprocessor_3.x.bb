DESCRIPTION = "Texas Instruments OpenMAX IL Pre Post Processor."
PR = "r2"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-ptrns ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/video/src/openmax_il/prepost_processor \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "prepost_processor"

inherit tiopenmax ccasefetch

SRC_URI = "file://prepostprocessornocore.patch;patch=1 \
	   file://prepostprocessortestnocore.patch;patch=1"
