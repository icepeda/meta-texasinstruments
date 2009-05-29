DESCRIPTION = "Texas Instruments OpenMAX IL G722 Encoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/g722_enc \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "g722_enc"

inherit tiopenmax ccasefetch

SRC_URI = "file://g722encmake.patch;patch=1 \
	   file://g722encnocore.patch;patch=1 \
	   file://g722enctestnocore.patch;patch=1"
