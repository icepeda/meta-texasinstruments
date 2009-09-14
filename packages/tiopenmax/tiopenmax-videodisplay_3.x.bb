DESCRIPTION = "Texas Instruments OpenMAX IL Video Display APP."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-resourcemanager tiopenmax-resourcemanagerproxy tiopenmax-lcml tiopenmax-postprocessor tiopenmax-videodecoder"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/application/src/openmax_il/video_display \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "video_display"

inherit tiopenmax ccasefetch

SRC_URI = "file://videodisplaynocore.patch;patch=1"
