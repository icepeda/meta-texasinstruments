DESCRIPTION = "Texas Instruments OpenMAX IL Camera."
PR = "r1"
DEPENDS = "mm-isp tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml tiopenmax-clock tiopenmax-postprocessor"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/video/src/openmax_il/camera \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "camera"

inherit tiopenmax ccasefetch

SRC_URI = "file://cameranocore.patch;patch=1 \
	   file://cameratestnocore.patch;patch=1"
