require linux-omap.inc
inherit ccasefetch

PR = "r0"

COMPATIBLE_MACHINE = "omap-3430(s|l)dp|omap-zoom2-(alpha|beta)"

CCASE_SPEC = "\
	element /vobs/wtbu/CSSD_L_GIT_2.6/linux/kernel_org/2.6_kernel/... LINUX-GIT-2.6.24K_RLS_5.24%\
	element * /main/LATEST%\
	"
CCASE_PATHFETCH = "/vobs/wtbu/CSSD_L_GIT_2.6/linux/kernel_org/2.6_kernel"
CCASE_PATHCOMPONENTS = 5
CCASE_PATHCOMPONENT = "2.6_kernel"

# You can supply your own defconfig if you like.  See
# http://bec-systems.com/oe/html/recipes_sources.html for a full explanation
#SRC_URI_omap-3430ldp += "file://defconfig-omap-3430ldp"
#SRC_URI_omap-3430sdp += "file://defconfig-omap-3430sdp"

# work-around for touchscreen problem (remove this when proper soln is found):
ADD_DISTRO_FEATURES += "sed -i 's/# CONFIG_INTERCONNECT_IO_POSTING is not set/CONFIG_INTERCONNECT_IO_POSTING=y/' ${S}/.config"

do_stage_append() {
	install -d ${STAGING_KERNEL_DIR}/drivers/media/video/isp
	install -m 0644 ${S}/drivers/media/video/isp/*.h ${STAGING_KERNEL_DIR}/drivers/media/video/isp
	install -d ${STAGING_KERNEL_DIR}/arch/arm/mach-omap2
	install -m 0644 ${S}/arch/arm/mach-omap2/*.h ${STAGING_KERNEL_DIR}/arch/arm/mach-omap2
}
