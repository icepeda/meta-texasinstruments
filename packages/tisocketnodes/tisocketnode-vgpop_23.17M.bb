DESCRIPTION = "Texas Instruments VGPOP Socket Node."
LICENSE = "LGPL"
PR = "r1"

require tisocketnode-cspec-${PV}.inc

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/video/alg/vgpop"
CCASE_PATHCOMPONENT = "vgpop"
CCASE_PATHCOMPONENTS = "5"

inherit ccasefetch

do_compile() {
}

do_stage() {
        chmod -R +w ${S}/*
	install -d ${STAGING_BINDIR}/dspbridge/video/alg/vgpop
	cp -a ${S}/* ${STAGING_BINDIR}/dspbridge/video/alg/vgpop
}
