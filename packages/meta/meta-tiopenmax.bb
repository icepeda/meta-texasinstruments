DESCRIPTION = "Texas Instruments OpenMAX IL."
PR = "r0"
PROVIDES = "virtual/openmax-il"
DEPENDS += "\
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
	${@base_contains("DISTRO_FEATURES", "jpegdec", "tiopenmax-jpegdec", "", d)} \
	${@base_contains("DISTRO_FEATURES", "jpegenc", "tiopenmax-jpegenc", "", d)} \
	\
	tiopenmax-camera \
	tiopenmax-postprocessor \
	tiopenmax-prepostprocessor \
	tiopenmax-rmparser \
	tiopenmax-rmrvparser \
	tiopenmax-rvdecoder \
	tiopenmax-videodecoder \
	tiopenmax-videoencoder \
	\
	tiopenmax-avplay \
	tiopenmax-avrecord \
	tiopenmax-imagecapture \
	tiopenmax-imagedisplay \
	tiopenmax-videocapture \
	tiopenmax-videodisplay \
	\
	tiopenmax-khronos \
	"
