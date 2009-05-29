DESCRIPTION = "Texas Instruments OpenMAX IL G726 Decoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/g726_dec \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "g726_dec"

inherit tiopenmax ccasefetch

SRC_URI = "file://g726decmake.patch;patch=1 \
	   file://g726decnocore.patch;patch=1 \
	   file://g726dectestnocore.patch;patch=1"
