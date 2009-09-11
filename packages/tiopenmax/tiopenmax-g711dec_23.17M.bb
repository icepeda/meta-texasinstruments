DESCRIPTION = "Texas Instruments OpenMAX IL G711 Decoder."
PR = "r2"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-ptrns ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/g711_dec \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "g711_dec"

inherit tiopenmax ccasefetch

SRC_URI = "file://g711decmake.patch;patch=1 \
	   file://g711decnocore.patch;patch=1 \
	   file://g711dectestnocore.patch;patch=1"

do_compile_prepend() {
	rm ${S}/audio/src/openmax_il/g711_dec/inc/TIDspOmx.h
	cp -f ${STAGING_INCDIR}/omx/TIDspOmx.h ${S}/audio/src/openmax_il/g711_dec/inc/
} 
