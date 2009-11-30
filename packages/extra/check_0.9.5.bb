DESCRIPTION = "a unit test framework for C"
LICENSE = "LGPL"
PRIORITY = "optional"
SECTION = "devel"

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/check/check-${PV}.tar.gz \
           file://configure_fix.patch;patch=1 \
           file://m4quote.patch;patch=1"
S = "${WORKDIR}/check-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF += "--enable-plain-docdir"

do_stage() {
	autotools_stage_all
}

