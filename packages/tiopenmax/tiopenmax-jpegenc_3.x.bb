DESCRIPTION = "Texas Instruments OpenMAX IL JPEG Encoder."
PR = "r2"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-ptrns ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/image/src/openmax_il/jpeg_enc \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "jpeg_enc"

inherit tiopenmax ccasefetch

ENV_VAR += "OMX_JPEG_PPLIB_ENABLED=1 "

SRC_URI = "file://jpegencnocore.patch;patch=1 \
	   file://jpegenctestnocore.patch;patch=1"
