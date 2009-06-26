DESCRIPTION = "Texas Instruments OpenMAX IL RV Decoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml tiopenmax-rmparser tiopenmax-rmrvparser"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/video/src/openmax_il/rv_decode \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "rv_decode"

inherit tiopenmax ccasefetch

SRC_URI = "file://rvdecodernocore.patch;patch=1 \
	   file://rvdecodertestnocore.patch;patch=1"
