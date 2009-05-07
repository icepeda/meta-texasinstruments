DESCRIPTION = "Texas Instruments JPEG Encoder Socket Node."
PR = "r0"
DEPENDS += "tisocketnode-jpegenc-codec \
	    tisocketnode-pplib"

CCASE_SPEC = "%\
	      element /vobs/wtbu/OMAPSW_DSP/image/node/jpeg/enc/... DSP-MM-TII-MM_RLS_${PV}%\
	      element * /main/LATEST%"

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/image/node/jpeg/enc"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/image/node/jpeg/enc

#set to release or debug
RELEASE = "release"

inherit ccasefetch tisocketnode

do_compile_prepend() {
	cp -r ${S}/../../tisocketnode-pplib-${PV}-r0/tisocketnode-pplib-${PV}/video ${S}
}
