DESCRIPTION = "Texas Instruments OpenMAX IL AVPlay APP."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-resourcemanager tiopenmax-resourcemanagerproxy tiopenmax-lcml tiopenmax-videodecoder tiopenmax-postprocessor tiopenmax-nbamrdec tiopenmax-aacdec tiopenmax-wbamrdec tiopenmax-wmadec"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/application/src/openmax_il/avplay \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "avplay"

inherit tiopenmax ccasefetch

SRC_URI = "file://avplaynocore.patch;patch=1"
