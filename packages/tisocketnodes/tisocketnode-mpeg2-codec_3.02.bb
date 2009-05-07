PRIORITY = "optional"
DESCRIPTION = "Texas Instruments MPEG-2 Decoder Socket Node Codec."
LICENSE = "LGPL"
PR = "r0"
DEPENDS = "baseimage"

CCASE_SPEC = "%\
	      element /vobs/wtbu/CSSD_MM_Releases/Codecs/video/mpeg2_dec/c64x/mm_tiicodecs/... DSP-MM-TII-MM_RLS_${PV}%\
	      element * /main/LATEST%"

CCASE_PATHFETCH = "/vobs/wtbu/CSSD_MM_Releases/Codecs/video/mpeg2_dec/c64x/mm_tiicodecs"
CCASE_PATHCOMPONENT = "mm_tiicodecs"
CCASE_PATHCOMPONENTS = "7"

inherit ccasefetch

do_compile() {
	unzip 100_V_MPEG2_D_MP_c64x+_1_05.zip
}

do_stage() {
        chmod -R +w ${S}/*
	install -d ${STAGING_BINDIR}/dspbridge/Codecs/video/mpeg2_dec/c64x/mm_tiicodecs/100_V_MPEG2_D_MP_c64x+_1_05
	cp -a ${S}/100_V_MPEG2_D_MP_c64x+_1_05/* ${STAGING_BINDIR}/dspbridge/Codecs/video/mpeg2_dec/c64x/mm_tiicodecs/100_V_MPEG2_D_MP_c64x+_1_05
}
