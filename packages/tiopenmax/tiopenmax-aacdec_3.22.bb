DESCRIPTION = "Texas Instruments OpenMAX IL AAC Decoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/aac_dec \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "aac_dec"

inherit tiopenmax ccasefetch

SRC_URI = "file://aacdecmake.patch;patch=1 \
	   file://aacdecnocore.patch;patch=1 \
	   file://aacdectestnocore.patch;patch=1 \
	   "
