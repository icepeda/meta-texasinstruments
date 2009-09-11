DESCRIPTION = "Texas Instruments WB-AMR Decoder Socket Node."
PR = "r0"
DEPENDS += "tisocketnode-wbamrdec-codec"

require tisocketnode-cspec-${PV}.inc

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/speech/node/wbamr/dec/"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/speech/node/wbamr/dec

inherit ccasefetch tisocketnode
