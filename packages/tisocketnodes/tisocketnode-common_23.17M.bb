DESCRIPTION = "Texas Instruments algo for IPP."
PR = "r0"

require tisocketnode-cspec-${PV}.inc

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/speech/node/common"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/speech/node/common

#set to release or debug
RELEASE = "release"

inherit ccasefetch tisocketnode
