DESCRIPTION = "Texas Instruments OpenMAX IL MP3 Decoder."
PR = "r1"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/mp3_dec \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "mp3_dec"

inherit tiopenmax ccasefetch

SRC_URI = "file://mp3decmake.patch;patch=1 \
	   file://mp3decnocore.patch;patch=1 \
	   file://mp3dectestnocore.patch;patch=1"

do_compile_prepend() {
	rm ${S}/audio/src/openmax_il/mp3_dec/inc/TIDspOmx.h
	cp -f ${STAGING_INCDIR}/omx/TIDspOmx.h ${S}/audio/src/openmax_il/mp3_dec/inc/
}
