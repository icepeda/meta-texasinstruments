DESCRIPTION = "Texas Instruments OpenMAX IL RAGECKO Decoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml tiopenmax-rmparser"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/ragecko_dec \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "ragecko_dec"

inherit tiopenmax ccasefetch

SRC_URI = "file://rageckodecmake.patch;patch=1 \
	   file://rageckodecnocore.patch;patch=1 \
	   file://rageckodectestnocore.patch;patch=1"
