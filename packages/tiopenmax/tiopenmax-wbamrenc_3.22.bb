DESCRIPTION = "Texas Instruments OpenMAX IL WBAMR Encoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/wbamr_enc \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "wbamr_enc"

inherit tiopenmax ccasefetch

SRC_URI = "file://wbamrencmake.patch;patch=1 \
	   file://wbamrencnocore.patch;patch=1 \
	   file://wbamrenctestnocore.patch;patch=1"
