DESCRIPTION = "Texas Instruments algo for IPP."
PR = "r0"

CCASE_SPEC = "%\
	      element /vobs/wtbu/OMAPSW_DSP/video  DSP-MM-TII-MM_RLS_${PV}%\
              element /vobs/wtbu/OMAPSW_DSP/video/lib/... DSP-MM-TII-MM_RLS_${PV}%\
	      element * /main/LATEST%"

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/video/lib"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/video/lib/conversions

#set to release or debug
RELEASE = "release"

inherit ccasefetch tisocketnode
