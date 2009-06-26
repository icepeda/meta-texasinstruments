DESCRIPTION = "Texas Instruments algo for IPP."
PR = "r0"

CCASE_SPEC = "%\
              element /vobs/wtbu/OMAPSW_DSP/audio/node/ul2dl... DSP-MM-TII_RLS_${PV}%\
	      element * /main/LATEST%"

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/audio/node/ul2dl"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/audio/node/ul2dl

#set to release or debug
RELEASE = "release"

inherit ccasefetch tisocketnode
