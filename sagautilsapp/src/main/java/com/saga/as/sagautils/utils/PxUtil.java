/**
 * @description:像素转换工具
 * @author chenshiqiang E-mail:csqwyyx@163.com
 * @date 2014年5月14日 上午12:09:47
 * @version 1.0
 */
package tw.com.as.sagautils.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public class PxUtil {

	public static DisplayMetrics getDisplayMetrics(Context context) {
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		return dm;
	}

	public static float dp2px(Context context, float dpValue) {
		return Math.round(dpValue * getDisplayMetrics(context).density);
	}

	public static float px2dp(Context context, float pxValue) {
		return Math.round(pxValue / getDisplayMetrics(context).density);
	}

	public static float sp2px(Context context, float pxValue) {
		return Math.round(pxValue * getDisplayMetrics(context).scaledDensity);
	}

	public static float px2sp(Context context, float pxValue) {
		return Math.round(pxValue / getDisplayMetrics(context).scaledDensity);
	}

	public static int getScreenWidth(Context context) {
		return (int)px2dp(context, getScreenWidthPx(context));
	}

	public static int getScreenHeight(Context context) {
		return (int)px2dp(context, getScreenHeightPx(context));
	}

	public static int getScreenWidthPx(Context context) {
		return getDisplayMetrics(context).widthPixels;
	}

	public static int getScreenHeightPx(Context context) {
		return getDisplayMetrics(context).heightPixels;
	}

	public static int dip2px(Context context, float dipValue) {
		return (int) (dipValue * getDisplayMetrics(context).density + 0.5f);
	}

	public static int px2dip(Context context, float pxValue) {
		return (int) (pxValue / getDisplayMetrics(context).density + 0.5f);
	}
}
