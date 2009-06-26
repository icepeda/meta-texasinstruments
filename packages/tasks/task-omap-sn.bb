#
# Copyright (C) 2008 Texas Instruments
#

DESCRIPTION = "Tasks for TI's Socket Nodes"
PR = "r3"

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

RDEPENDS = "\
    tisocketnode-control-task \
    tisocketnode-ipp \
    tisocketnode-dfgm \
    tisocketnode-usn \
    \
    tisocketnode-mp3 \
    tisocketnode-mpeg4aacdec \
    tisocketnode-mpeg4aacenc \
    tisocketnode-wma9 \
    tisocketnode-pcmdec \
    tisocketnode-pcmenc \
    tisocketnode-ima-adpcmdec \
    tisocketnode-ima-adpcmenc \
    \
    tisocketnode-nbamrdec \
    tisocketnode-nbamrenc \
    tisocketnode-wbamrdec \
    tisocketnode-wbamrenc \
    tisocketnode-gsmfrdec \
    tisocketnode-gsmfrenc \
    tisocketnode-gsmhrdec \
    tisocketnode-gsmhrenc \
    \
    tisocketnode-g711dec \
    tisocketnode-g711enc \
    tisocketnode-g722dec \
    tisocketnode-g722enc \
    tisocketnode-g723dec \
    tisocketnode-g723enc \
    tisocketnode-g726dec \
    tisocketnode-g726enc \
    tisocketnode-g729dec \
    tisocketnode-g729enc \
    tisocketnode-ilbcdec \
    tisocketnode-ilbcenc \
    ${@base_contains("DISTRO_FEATURES", "rarv", "tisocketnode-rageckodec", "", d)} \
    \
    tisocketnode-h264dec \
    tisocketnode-h264enc \
    tisocketnode-mpeg4dec \
    tisocketnode-mpeg4enc \
    ${@base_contains("DISTRO_FEATURES", "720p", "tisocketnode-mpeg4-720pdec", "", d)} \
    ${@base_contains("DISTRO_FEATURES", "720p", "tisocketnode-mpeg4-720penc", "", d)} \
    tisocketnode-wmv9 \
    tisocketnode-mpeg2 \
    tisocketnode-spark \
    tisocketnode-vpp \
    tisocketnode-ringio \
    ${@base_contains("DISTRO_FEATURES", "rarv", "tisocketnode-rv89combodec", "", d)} \
    \
    tisocketnode-pplib \
    tisocketnode-conversions \
    tisocketnode-jpegdec \
    tisocketnode-jpegenc \
    \
    "

DEPENDS = "\
    tisocketnode-algo \
    tisocketnode-nmu-plc-vad \
    tisocketnode-vgpop \
    "
