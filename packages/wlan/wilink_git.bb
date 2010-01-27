SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "WLAN stack (kernel module, libs, wpa_supplicant)"
DEPENDS = "linux-tiomap wilink-firmware"
LICENSE = "GPL"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "omap-3430ldp|omap-3430sdp|omap-3630sdp|zoom2|zoom3"

PACKAGES = "${PN}"
FILES_${PN} += "/wlan"

inherit pkgconfig

S = "${WORKDIR}/git"

PV = "23.i3+git+${SRCREV}"

SRC_URI = "git://dev.omapzoom.org/pub/scm/vijay/wlan.git;protocol=git;branch=master"
AR = "ar"
KERNEL_SOURCE = "${TMPDIR}/work/${MULTIMACH_TARGET_SYS}/linux-tiomap-2.6+git${SRCREV_pn-linux-tiomap}-r1/git"

do_compile() {
	cd ${S}/platforms/os/linux
	cp ${STAGING_DIR_TARGET}/fw/firmware.bin ${S}/platforms/os/linux/.
    cp ${STAGING_DIR_TARGET}/fw/Fw1273_CHIP.bin ${S}/fw/Latest/.
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

	make ARCH=arm HOST_PLATFORM=${MACHINE} KERNEL_DIR=${KERNEL_SOURCE} \
	CROSS_COMPILE=arm-none-linux-gnueabi- BUILD_SUPPL=n clean

#	oe_runmake ARCH=arm HOST_PLATFORM=${MACHINE} KERNEL_DIR=${STAGING_KERNEL_DIR}/../../../work/zoom3-none-linux-gnueabi/linux-tiomap-2.6+git37faa029b18b2b148eb4f54011ef3fd666c92cd7-r1/git \
    make ARCH=arm HOST_PLATFORM=${MACHINE} KERNEL_DIR=${KERNEL_SOURCE} \ 
	CROSS_COMPILE=arm-none-linux-gnueabi- BUILD_SUPPL=n
}
