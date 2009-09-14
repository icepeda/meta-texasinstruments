CCASE_SPEC = "\
	# OMX Audio%\
	element /vobs/wtbu/OMAPSW_MPU/linux/audio/... FLOAT-LINUX-MMAUDIO_RLS_${PV}%\
	# OMX Video%\
	element /vobs/wtbu/OMAPSW_MPU/linux/video/... FLOAT-LINUX-MMVIDEO_RLS_${PV}%\
	# OMX Image%\
	element /vobs/wtbu/OMAPSW_MPU/linux/image/... FLOAT-LINUX-MMIMAGE_RLS_${PV}%\
	# OMX System%\
	element /vobs/wtbu/OMAPSW_MPU/linux/system/... FLOAT-LINUX-MMSYSTEM_RLS_${PV}%\
	# OMX Application%\
	element /vobs/wtbu/OMAPSW_MPU/linux/application/... FLOAT-LINUX-MMAPPLICATION_RLS_${PV}%\
	# OMX INST2 utilities%\
	element /vobs/wtbu/OMAPSW_MPU/linux/utilities/src/inst2/... LINUX-MMUTILS_RLS_3.02.03%\
	# ROOT folder & Make files%\
	element /vobs/wtbu/OMAPSW_MPU/linux/... LINUX-MMROOT_RLS_3.20%\
	\
	element * /main/LATEST%\
	"
