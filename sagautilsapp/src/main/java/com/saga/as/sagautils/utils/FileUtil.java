package tw.com.as.sagautils.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;

public class FileUtil
{
	private static final String TAG = "FileUtil";

	/** 取得檔案的MIME類型 */
	public static String getMIMEType(String file)
	{
		MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
		String extension = getFileExtension(file);
		return mimeTypeMap.getMimeTypeFromExtension(extension);
	}

	/** 取得檔案的副檔名 */
	public static String getFileExtension(String file)
	{
		String extension = MimeTypeMap.getFileExtensionFromUrl(file);
		if (TextUtils.isEmpty(extension))
		{
			// getMimeTypeFromExtension() doesn't handle spaces in filenames nor
			// can it handle
			// urlEncoded strings. Let's try one last time at finding the
			// extension.
			int dotPos = file.lastIndexOf('.');
			if (0 <= dotPos)
			{
				extension = file.substring(dotPos + 1);
			}
		}
		return extension;
	}
	
	/**
	 * 從檔案路徑取得檔案大小
	 * @param filePath 檔案大小
	 */
	public static long getFileSize(String filePath){
		if(TextUtils.isEmpty(filePath)){
			return 0;
		}
		
		File f = new File(filePath);
		if(f.exists()){
			return f.length();
		}
		return 0;
	}
	
	/**
	 * @author chenshiqiang
	 * Description: 從檔案大小取得檔案大小的文字（如xxMB）
	 * @param fileLength
	 * @return
	 */
    public static String getSizeStr(long fileLength) {
    	String strSize = "";
		try {
			if(fileLength >= 1024*1024*1024){
				strSize = (float)Math.round(10*fileLength/(1024*1024*1024))/10 + " GB";
			}else if(fileLength >= 1024*1024){
				strSize = (float)Math.round(10*fileLength/(1024*1024*1.0))/10 + " MB";
			}else if(fileLength >= 1024){
				strSize = (float)Math.round(10*fileLength/(1024))/10 + " KB";
			}else if(fileLength >= 0){
				strSize = fileLength + " B";
			}else {
				strSize = "0 B";
			}
		} catch (Exception e) {
			e.printStackTrace();
			strSize = "0 B";
		}
		return strSize;
	}

	/** 判斷SDcard是否存在 */
	public static boolean isSdcardExist()
	{
		return Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);
	}

	/**
	 * 如果SDcard存在，則返回SDcard上的普通文件的目錄 否則，失敗返回null
	 */
	public static String makeDir(String dir)
	{
		if (!isSdcardExist())
		{
			return null;
		}
		File file = new File(dir);
		if (!file.exists())
		{
			if (!file.mkdirs())
			{
				Log.e(TAG, "--->create file dir fail!");
				return null;
			}
		}
		return dir;
	}

	public static File makeDirFile(String dir)
	{
		String dirPath = makeDir(dir);
		if (dirPath != null)
		{
			return new File(dirPath);
		}
		else
		{
			return null;
		}
	}

	/**
	 * 另外建立檔案命名並複製
	 * 
	 * @param src
	 *            來源檔案
	 * @param dest
	 *            目標檔案
	 * @param recoverd
	 *            是否覆蓋
	 * @throws IOException
	 * @return -- 0 ：成功 1:檔案已存在，提示詢問 -- -1：參數不正確 -2：來源不存在 -3：來源不是文件
	 * 			- 4：來源不能讀取 -5:目標不是文件 -6:目標不可寫入 -7:讀取異常
	 * */
	public static int saveFile(String src, String dest, boolean recoverd)
			throws IOException
	{
		if (src == null || dest == null)
		{
			// 參數不正確
			return -1;
		}
		File srcFile = new File(src);
		// 來源不存在
		if (!srcFile.exists())
		{
			return -2;
		}
		// 來源不是文件
		if (!srcFile.isFile())
		{
			return -3;
		}
		// 來源不能讀取
		if (!srcFile.canRead())
		{
			return -4;
		}
		File destFile = new File(dest);
		// 判斷目標檔案是否存在，提示是否覆蓋，或者重新命名
		if (destFile.exists())
		{
			if (recoverd)
			{
				// 覆蓋
				destFile.delete();
			}
			else
			{
				// 詢問 提示 重新命名
				return 1;
			}
		}
		// 一定是不存在的
		destFile.createNewFile();
		// 目標不是文件
		if (!destFile.isFile())
		{
			return -5;
		}
		// 目標不可寫入
		if (!destFile.canWrite())
		{
			return -6;
		}
		FileInputStream fileIn = null;
		FileOutputStream fileOut = null;
		byte[] buffer = new byte[8192];
		int count = 0;
		// 開始複製文件
		try
		{
			fileIn = new FileInputStream(srcFile);
			fileOut = new FileOutputStream(destFile);
			while ((count = fileIn.read(buffer)) > 0)
			{
				fileOut.write(buffer, 0, count);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return -7;
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
			return -7;
		}
		finally
		{
			// 關閉 輸入 輸出 Stream
			if (fileIn != null)
				fileIn.close();
			if (fileOut != null)
				fileOut.close();
		}
		return 0;
	}

	/**
	 * 將對像序列化
	 * @param o
	 * @return
	 */
	public static byte[] objectToBytes(Object o)
	{
		byte[] bytes;
		ByteArrayOutputStream out = null;
		ObjectOutputStream sOut = null;
		try
		{
			out = new ByteArrayOutputStream();
			sOut = new ObjectOutputStream(out);
			sOut.writeObject(o);
			sOut.flush();
			bytes = out.toByteArray();
			return bytes;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (out != null)
				{
					out.close();
				}
				if (sOut != null)
				{
					sOut.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 反序列化
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
    public static Object bytesToObject(byte[] bytes)
    {
        // logger.debug("bytesToObject called ");
        // byte轉object
        ByteArrayInputStream in = null ;
        ObjectInputStream sIn = null;
        try{
        	 in = new ByteArrayInputStream(bytes);
             sIn = new ObjectInputStream(in);
             return sIn.readObject();
        }catch(Exception e){
        	e.printStackTrace();
        }finally
        {
        	try{
        		if(in != null)
        		{
        			in.close();
        		}
        		if(sIn != null)
        		{
        			sIn.close();
        		}
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
       

        return null;
    }
    
    public static String getPathFromUri(final Activity context,final Uri uri) {
    	String path = "";
        if(uri != null){
            String[] proj = { MediaStore.Images.Media.DATA };
            Cursor cursor = context.managedQuery(uri, proj, null, null,
                    null);
            if(cursor != null && cursor.getCount() > 0){
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                path = cursor.getString(column_index);
            }
        }
        return path;
	}
    
}