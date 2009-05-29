DESCRIPTION = "Texas Instruments OpenMAX IL PCM Decoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/pcm_dec \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "pcm_dec"

inherit tiopenmax ccasefetch

SRC_URI = "file://pcmdecmake.patch;patch=1 \
	   file://pcmdecnocore.patch;patch=1 \
	   file://pcmdectestnocore.patch;patch=1"
