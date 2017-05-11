/**
 * @description: 
 * @author chenshiqiang E-mail:csqwyyx@163.com
 * @date 2014年6月1日 下午5:16:37   
 * @version 1.0   
 */
package tw.com.as.sagautils.utils;

import java.util.List;

import android.content.pm.PackageInfo;

import tw.com.as.sagautils.app.App;

public class GsfUtil {

	public static String pkgGoogleServiceFramwork = "com.google.android.gsf";
	
	
	/**
	 * @description: 判断谷歌服务框架是否已安装
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @return
	 */
	public static boolean isGsfInstalled(){
		List<PackageInfo> ps = App.app.getPackageManager().getInstalledPackages(0);
		if(ps != null && !ps.isEmpty()){
			for(PackageInfo pi : ps){
				if(pi.packageName.contains(pkgGoogleServiceFramwork)){
					return true;
				}
			}
		}
		return false;
	}
}
