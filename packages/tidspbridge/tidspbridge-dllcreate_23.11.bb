PRIORITY = "optional"
DESCRIPTION = "Texas Instruments DSP Bridge tool DLLcreate"
LICENSE = "Texas Instruments"
PR = "r0"

CCASE_SPEC = "%\
              element /vobs/SDS/Source/Dload/dload/... .../dyn-load_rel_1.x/LATEST%\
	      element * /main/LATEST%"

CCASE_PATHFETCH = "/vobs/SDS/Source/Dload/dload/src"
CCASE_PATHCOMPONENT = "src"
CCASE_PATHCOMPONENTS = "5"

SRC_URI = "file://DLLcreate.patch;patch=1"

<<<<<<< HEAD:packages/tidspbridge/tidspbridge-dllcreate_23.11.bb
inherit ccasefetch
=======
S = ${WORKDIR}/${PN}-${PV}

inherit ccasefetch native

# DLLcreate is not portable to 64bit environment, so force it to
# be built as a 32bit executable, even if we are using an x86_64
# machine to build:
export GCC = "gcc -m32"
>>>>>>> 626de0bae71d3609336726cc4095b4834faeed58:packages/tidspbridge/tidspbridge-dllcreate-native_23.11.bb

do_compile() {
	cd DLLcreate
        chmod -R +w *
	mkdir -p linux/release
	oe_runmake -f makefile.lin	
}

do_stage() {
	cd ${STAGING_BINDIR}
	install -d ${STAGING_BINDIR}/DLLcreate
	install -m 0755 ${S}/DLLcreate/linux/release/DLLcreate ${STAGING_BINDIR}/DLLcreate
}
