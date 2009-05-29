DESCRIPTION = "Texas Instruments OpenMAX IL ILBC Encoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/ilbc_enc \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "ilbc_enc"

inherit tiopenmax ccasefetch

SRC_URI = "file://ilbcencmake.patch;patch=1 \
	   file://ilbcencnocore.patch;patch=1 \
	   file://ilbcenctestnocore.patch;patch=1"
