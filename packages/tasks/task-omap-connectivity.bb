#
# Copyright (C) 2008 Texas Instruments
#

DESCRIPTION = "Tasks for TI's connectivity package"
PR = "r3"

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

RDEPENDS = "\
	${@base_contains("DISTRO_FEATURES", "tibluetooth", "btfm", "", d)} \
	${@base_contains("DISTRO_FEATURES", "tibluetooth", "fmapp", "", d)} \
	${@base_contains("DISTRO_FEATURES", "tiwifi", "wilink", "", d)} \
	${@base_contains("DISTRO_FEATURES", "tiwifi", "iperf", "", d)} \
	${@base_contains("DISTRO_FEATURES", "tibluetooth", "bluez-gnome", "", d)} \
	${@base_contains("DISTRO_FEATURES", "tibluetooth", "obex-data-server", "", d)} \
"
