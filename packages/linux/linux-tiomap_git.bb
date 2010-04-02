RDEPENDS="l23-init-extra"

require linux-omap.inc

PR = "r1"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-omap3.git;protocol=git;branch=beta-next"

PV = "2.6+git${SRCREV}"

S = "${WORKDIR}/git"


COMPATIBLE_MACHINE = "omap-3430ldp|omap-3430sdp|omap-3630sdp|zoom2|zoom3"

DEFAULT_PREFERENCE = "1"

# You can supply your own defconfig if you like.  See
# http://bec-systems.com/oe/html/recipes_sources.html for a full explanation
SRC_URI += " \
           file://0001-DSPBRIDGE-patch-for-L23.I3.6-PRE2.patch;patch=1 \
  	   "



