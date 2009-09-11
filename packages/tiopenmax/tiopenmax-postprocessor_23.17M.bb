DESCRIPTION = "Texas Instruments OpenMAX IL Post Processor."
PR = "r2"
DEPENDS = "tiopenmax-core tiopenmax-audiomanager tiopenmax-resourcemanager tiopenmax-lcml tiopenmax-clock"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-ptrns ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/video/src/openmax_il/post_processor \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "post_processor"

inherit tiopenmax ccasefetch

SRC_URI = "file://omap24xxvout.h \
	   file://postprocessornocore.patch;patch=1 \
	   file://postprocessortestnocore.patch;patch=1"

do_compile_prepend() {
	install -m 0644 ${FILESDIR}/omap24xxvout.h ${S}/video/src/openmax_il/post_processor/inc/omap24xxvout.h
}

