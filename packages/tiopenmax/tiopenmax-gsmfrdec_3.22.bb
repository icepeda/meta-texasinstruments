DESCRIPTION = "Texas Instruments OpenMAX IL GSMFR Decoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/gsmfr_dec \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "gsmfr_dec"

inherit tiopenmax ccasefetch

SRC_URI = "file://gsmfrdecmake.patch;patch=1 \
	   file://gsmfrdecnocore.patch;patch=1 \
	   file://gsmfrdectestnocore.patch;patch=1"
