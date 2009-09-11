DESCRIPTION = "Texas Instruments Real Video Socket Node."
PR = "r0"
DEPENDS += "tisocketnode-rv89combodec-codec"

require tisocketnode-cspec-${PV}.inc

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/video/node/rv89combo/dec"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/video/node/rv89combo/dec

inherit ccasefetch tisocketnode
