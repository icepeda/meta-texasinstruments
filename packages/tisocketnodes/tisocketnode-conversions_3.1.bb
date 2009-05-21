DESCRIPTION = "Texas Instruments Conversion library."
PR = "r2"
DEPENDS = "baseimage tisocketnode-usn"

CCASE_SPEC = "%\
	      element /vobs/wtbu/OMAPSW_DSP/video/... DSP-MM-TII-MM_RLS_${PV}%\
	      element * /main/LATEST%"

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/video/lib/conversions"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/video/lib/conversions

#set to release or debug
RELEASE = "release"

do_stage() {
	install -d ${STAGING_BINDIR}/dspbridge/video/lib/conversions
	mkdir -p ${STAGING_BINDIR}/dspbridge/video/lib/conversions/inc
	cp -a ${S}/video/lib/conversions/inc/* ${STAGING_BINDIR}/dspbridge/video/lib/conversions/inc
	cp -a ${S}/video/lib/conversions/config.pl ${STAGING_BINDIR}/dspbridge/video/lib/conversions
}

inherit ccasefetch tisocketnode
