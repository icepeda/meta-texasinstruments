DESCRIPTION = "Texas Instruments PPLIB library."
PR = "r1"
DEPENDS = "baseimage tisocketnode-usn tisocketnode-vpp"

CCASE_SPEC = "%\
	      element /vobs/wtbu/OMAPSW_DSP/video/... DSP-MM-TII_RLS_${PV}%\
	      element * /main/LATEST%"

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/video/lib/pplib_dualout"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/video/lib/pplib_dualout

#set to release or debug
RELEASE = "release"

do_compile_prepend() {
	## Getting VGPOP files
	mkdir -p ${S}/video/alg/vgpop
	cp -a ${STAGING_BINDIR}/dspbridge/video/alg/vgpop/* ${S}/video/alg/vgpop
	## Getting SRC files
        #mkdir -p ${S}/audio/alg/SampleRateConverter
        #cp -a ${STAGING_BINDIR}/dspbridge/audio/alg/SampleRateConverter/* ${S}/audio/alg/SampleRateConverter
}

do_stage() {
	install -d ${STAGING_BINDIR}/dspbridge/video/lib/pplib_dualout
	mkdir ${STAGING_BINDIR}/dspbridge/video/lib/pplib_dualout/inc
	cp -a ${S}/video/lib/pplib_dualout/inc/* ${STAGING_BINDIR}/dspbridge/video/lib/pplib_dualout/inc
	cp -a ${S}/video/lib/pplib_dualout/config.pl ${STAGING_BINDIR}/dspbridge/video/lib/pplib_dualout
}

inherit ccasefetch tisocketnode
