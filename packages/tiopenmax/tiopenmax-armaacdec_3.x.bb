DESCRIPTION = "Texas Instruments OpenMAX IL ARMAAC Decoder."
PR = "r2"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-ptrns ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/audio/src/openmax_il/armaac_dec \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "armaac_dec"

inherit tiopenmax ccasefetch

SRC_URI = "file://armaacdecmake.patch;patch=1 \
	   file://armaacdecnocore.patch;patch=1 \
	   file://armaacdectestnocore.patch;patch=1"

do_compile_prepend() {
	rm ${S}/audio/src/openmax_il/armaac_dec/inc/TIDspOmx.h
	cp -f ${STAGING_INCDIR}/omx/TIDspOmx.h ${S}/audio/src/openmax_il/armaac_dec/inc/
} 
