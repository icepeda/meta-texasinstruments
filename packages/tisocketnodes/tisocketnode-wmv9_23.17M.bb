DESCRIPTION = "Texas Instruments Windows Media Video 9 Socket Node."
PR = "r0"
DEPENDS += "tisocketnode-wmv9-codec"

require tisocketnode-cspec-${PV}.inc

CCASE_PATHFETCH = "/vobs/wtbu/OMAPSW_DSP/video/node/wmv9/dec"
CCASE_PATHCOMPONENT = "OMAPSW_DSP"
CCASE_PATHCOMPONENTS = "2"

SN_DIR=${S}/video/node/wmv9/dec

#set to release or debug
RELEASE = "release"

inherit ccasefetch tisocketnode
