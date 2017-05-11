package tw.com.as.sagautils.constant;

import java.io.File;

import android.os.Environment;

public class PathConstants {
	/**
	 * 1应用文件夹
	 */
	public static final String AppFolderName = "TheSceneryAlong";
	/**
	 * 2数据库文件夹
	 */
	public static final String DbFolderName = "db";
	/**
	 * 2导入文件夹
	 */
	public static final String ImportFolderName = "import";
	/**
	 * 2导出文件夹
	 */
	public static final String ExportFolderName = "export";
	/**
	 * 2media缓存文件夹
	 */
	public static final String MediaCacheFolderName = "mediacache";
	/**
	 * 2缩略图文件夹
	 */
	public static final String ThumbFolderName = "thumb";
	

	/**
	 * sd卡路径
	 */
	private static final String SdcardPath = Environment.getExternalStorageDirectory()
			.getAbsolutePath();

	/**
	 * 1应用路径
	 */
	private static final String AppPath = SdcardPath + File.separator + AppFolderName;
	
	/**
	 * 2数据库文件路径
	 */
	private static final String DbPath = AppPath + File.separator + DbFolderName;
	
	/**
	 * 2导入文件路径
	 */
	private static final String ImportPath = AppPath + File.separator + ImportFolderName;
	
	/**
	 * 2导出文件路径
	 */
	private static final String ExportPath = AppPath + File.separator + ExportFolderName;
	
	/**
	 * 2media缓存文件路径
	 */
	private static final String MediaCachePath = AppPath + File.separator + MediaCacheFolderName;
	
	/**
	 * 2缩略图缓存文件路径
	 */
	private static final String ThumbCachePath = AppPath + File.separator + ThumbFolderName;

	static{
		//有些目录还是得提前帮助生成，不管是否使用
		checkExist(AppPath);
		checkExist(DbPath);
		checkExist(ImportPath);
		checkExist(ExportPath);
		checkExist(MediaCachePath);
		checkExist(ThumbCachePath);
	}
	
    
	public static String getSdcardpath() {
		return SdcardPath;
	}

	public static String getApppath() {
		checkExist(AppPath);
		return AppPath;
	}

	public static String getDbpath() {
		checkExist(DbPath);
		return DbPath;
	}

	public static String getImportpath() {
		checkExist(ImportPath);
		return ImportPath;
	}

	public static String getExportpath() {
		checkExist(ExportPath);
		return ExportPath;
	}

	public static String getMediacachepath() {
		checkExist(MediaCachePath);
		return MediaCachePath;
	}
	
	public static String getThumbpath() {
		checkExist(ThumbCachePath);
		return ThumbCachePath;
	}


	public static final void checkExist(String path){
		File f = new File(path);
	    if(!f.exists()){
	        f.mkdirs();
	    }
	}

}
