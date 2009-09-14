DESCRIPTION = "Texas Instruments OpenMAX IL ARMAAC Encoder."
PR = "r2"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-ptrns ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/armaac_enc \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "armaac_enc"

inherit tiopenmax ccasefetch

SRC_URI = "file://armaacencmake.patch;patch=1 \
	   file://armaacencnocore.patch;patch=1 \
	   file://armaacenctestnocore.patch;patch=1"

do_compile_prepend() {
	rm ${S}/audio/src/openmax_il/armaac_enc/inc/TIDspOmx.h
	cp -f ${STAGING_INCDIR}/omx/TIDspOmx.h ${S}/audio/src/openmax_il/armaac_enc/inc/
} 
