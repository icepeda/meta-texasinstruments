DESCRIPTION = "Texas Instruments JPEG Encoder Socket Node."
PR = "r0"
DEPENDS += "tisocketnode-jpegenc-codec \
	    tisocketnode-conversions \
	    tisocketnode-pplib"

require tisocketnode-cspec-${PV}.inc

CCASE_PATHFETCH = " /vobs/wtbu/OMAPSW_DSP/image/node/jpeg"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/image/node/jpeg/enc

#set to release or debug
RELEASE = "release"

inherit ccasefetch tisocketnode

do_compile_prepend() {
	cp -r ${STAGING_BINDIR}/dspbridge/video ${S}
}
