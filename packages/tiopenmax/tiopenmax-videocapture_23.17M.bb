DESCRIPTION = "Texas Instruments OpenMAX IL Video Capture APP."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-resourcemanager tiopenmax-resourcemanagerproxy tiopenmax-lcml tiopenmax-camera tiopenmax-videoencoder"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/application/src/openmax_il/video_capture \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "video_capture"

inherit tiopenmax ccasefetch

SRC_URI = "file://videocapturenocore.patch;patch=1"
