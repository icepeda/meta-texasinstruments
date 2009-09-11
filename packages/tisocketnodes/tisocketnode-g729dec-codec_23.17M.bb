PRIORITY = "optional"
DESCRIPTION = "Texas Instruments G729 Decoder Socket Node Codec."
LICENSE = "LGPL"
PR = "r0"
DEPENDS = "baseimage"

require tisocketnode-cspec-${PV}.inc

CCASE_PATHFETCH = "/vobs/wtbu/CSSD_MM_Releases/Codecs/speech/g729_dec/c64x/mm_tiicodecs"
CCASE_PATHCOMPONENT = "mm_tiicodecs"
CCASE_PATHCOMPONENTS = "7"

inherit ccasefetch

do_compile() {
	unzip g729ab_x_all_c64xplus.zip
}

do_stage() {
        chmod -R +w ${S}/*
	install -d ${STAGING_BINDIR}/dspbridge/Codecs/speech/g729_dec/c64x/mm_tiicodecs/g729ab_x_all_c64xplus
	cp -a ${S}/g729ab_x_all_c64xplus/* ${STAGING_BINDIR}/dspbridge/Codecs/speech/g729_dec/c64x/mm_tiicodecs/g729ab_x_all_c64xplus
}
