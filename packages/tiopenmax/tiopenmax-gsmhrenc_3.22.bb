DESCRIPTION = "Texas Instruments OpenMAX IL GSMHR Encoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/gsmhr_enc \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "gsmhr_enc"

inherit tiopenmax ccasefetch

SRC_URI = "file://gsmhrencmake.patch;patch=1 \
	   file://gsmhrencnocore.patch;patch=1 \
	   file://gsmhrenctestnocore.patch;patch=1"
