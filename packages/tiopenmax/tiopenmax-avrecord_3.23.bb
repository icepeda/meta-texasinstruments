DESCRIPTION = "Texas Instruments OpenMAX IL AVRecord APP."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-resourcemanager tiopenmax-resourcemanagerproxy tiopenmax-lcml tiopenmax-camera tiopenmax-videoencoder tiopenmax-nbamrenc tiopenmax-aacenc tiopenmax-wbamrenc"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/application/src/openmax_il/avrecord \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "avrecord"

inherit tiopenmax ccasefetch

SRC_URI = "file://avrecordnocore.patch;patch=1"
