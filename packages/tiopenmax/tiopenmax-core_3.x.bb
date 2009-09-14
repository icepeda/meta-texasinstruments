DESCRIPTION = "Texas Instruments OpenMAX IL Core."
PR = "r1"
DEPENDS = "tidspbridge-lib tiopenmax-perf tiopenmax-common"
PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

require tiopenmax-cspec-${PV}.inc
CCASE_PATHFETCH = "\
	/vobs/wtbu/OMAPSW_MPU/linux/system/src/openmax_il/omx_core \
	/vobs/wtbu/OMAPSW_MPU/linux/Makefile \
	/vobs/wtbu/OMAPSW_MPU/linux/Master.mk \
	"
CCASE_PATHCOMPONENT = "linux"
CCASE_PATHCOMPONENTS = 3
OMX_COMPONENT = "core"

inherit tiopenmax ccasefetch

SRC_URI = "file://libomxil-ti.pc"

do_compile_prepend() {
	install -m 0644 ${FILESDIR}/libomxil-ti.pc ${S}/libomxil.pc
}
