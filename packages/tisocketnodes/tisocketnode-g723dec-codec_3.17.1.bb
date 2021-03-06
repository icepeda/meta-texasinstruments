PRIORITY = "optional"
DESCRIPTION = "Texas Instruments G723 Decoder Socket Node Codec."
LICENSE = "LGPL"
PR = "r0"
DEPENDS = "baseimage"

CCASE_SPEC = "%\
	      element /vobs/wtbu/CSSD_MM_Releases/Codecs/speech/g723_dec/c64x/mm_tiicodecs/... DSP-MM-TID-AUDIO_RLS_${PV}%\
	      element * /main/LATEST%"

CCASE_PATHFETCH = "/vobs/wtbu/CSSD_MM_Releases/Codecs/speech/g723_dec/c64x/mm_tiicodecs"
CCASE_PATHCOMPONENT = "mm_tiicodecs"
CCASE_PATHCOMPONENTS = "7"

inherit ccasefetch

do_compile() {
	unzip g7231a_x_all_c64xplus.zip
}

do_stage() {
	chmod -R +w ${S}/*
	install -d ${STAGING_BINDIR}/dspbridge/Codecs/speech/g723_dec/c64x/mm_tiicodecs/g7231a_x_all_c64xplus
	cp -a ${S}/g7231a_x_all_c64xplus/* ${STAGING_BINDIR}/dspbridge/Codecs/speech/g723_dec/c64x/mm_tiicodecs/g7231a_x_all_c64xplus
}
