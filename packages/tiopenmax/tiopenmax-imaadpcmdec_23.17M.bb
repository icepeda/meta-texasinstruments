DESCRIPTION = "Texas Instruments OpenMAX IL IMAADPCM Decoder."
PR = "r2"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-ptrns ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/imaadpcm_dec \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "imaadpcm_dec"

inherit tiopenmax ccasefetch

SRC_URI = "file://imaadpcmdecmake.patch;patch=1 \
	   file://imaadpcmdecnocore.patch;patch=1 \
	   file://imaadpcmdectestnocore.patch;patch=1"

do_compile_prepend() {
	rm ${S}/audio/src/openmax_il/imaadpcm_dec/inc/TIDspOmx.h
	cp -f ${STAGING_INCDIR}/omx/TIDspOmx.h ${S}/audio/src/openmax_il/imaadpcm_dec/inc/
}
