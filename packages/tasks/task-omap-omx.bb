#
# Copyright (C) 2008 Texas Instruments
#

DESCRIPTION = "Tasks for TI's OpenMAX IL"
PR = "r2"

PACKAGES = "\
	task-omap-omx \
	task-omap-omx-libs \
	task-omap-omx-utils \
	task-omap-omx-apps \
	"

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

RDEPENDS_task-omap-omx = "\
	task-omap-omx-libs \
	task-omap-omx-utils \
	task-omap-omx-apps \
	"

RDEPENDS_task-omap-omx-libs = "\
	tiopenmax-audiomanager \
	tiopenmax-clock \
	tiopenmax-common \
	tiopenmax-core \
	tiopenmax-lcml \
	tiopenmax-perf \
	tiopenmax-policymanager \
	tiopenmax-resourcemanager \
	tiopenmax-resourcemanagerproxy \
	\
	tiopenmax-aacdec \
	tiopenmax-aacenc \
	tiopenmax-armaacdec \
	tiopenmax-armaacenc \
	tiopenmax-g711dec \
	tiopenmax-g711enc \
	tiopenmax-g722dec \
	tiopenmax-g722enc \
	tiopenmax-g723dec \
	tiopenmax-g723enc \
	tiopenmax-g726dec \
	tiopenmax-g726enc \
	tiopenmax-g729dec \
	tiopenmax-g729enc \
	tiopenmax-gsmfrdec \
	tiopenmax-gsmfrenc \
	tiopenmax-gsmhrdec \
	tiopenmax-gsmhrenc \
	tiopenmax-ilbcdec \
	tiopenmax-ilbcenc \
	tiopenmax-imaadpcmdec \
	tiopenmax-imaadpcmenc \
	tiopenmax-mp3dec \
	tiopenmax-nbamrdec \
	tiopenmax-nbamrenc \
	tiopenmax-pcmdec \
	tiopenmax-pcmenc \
	tiopenmax-rageckodec \
	tiopenmax-wbamrdec \
	tiopenmax-wbamrenc \
	tiopenmax-wmadec \
	\
	tiopenmax-jpegdec \
	tiopenmax-jpegenc \
	\
	tiopenmax-camera \
	tiopenmax-postprocessor \
	tiopenmax-prepostprocessor \
	tiopenmax-rmparser \
	tiopenmax-rmrvparser \
	tiopenmax-rvdecoder \
	tiopenmax-videodecoder \
	tiopenmax-videoencoder \
	"

RDEPENDS_task-omap-omx-utils = "\
	tiopenmax-khronos \
	"

RDEPENDS_task-omap-omx-apps = "\
	tiopenmax-avplay \
	tiopenmax-avrecord \
	tiopenmax-imagecapture \
	tiopenmax-imagedisplay \
	tiopenmax-videocapture \
	tiopenmax-videodisplay \
	"
