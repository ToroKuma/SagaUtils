package tw.com.as.sagautils.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;

import org.xutils.common.util.DensityUtil;

/**
 * Created by AS on 2016/9/27.
 */

public class DrawableUtils {
    public static GradientDrawable getDrawable(int rgb, float radius){
        GradientDrawable gradientDrawable = new GradientDrawable();

        gradientDrawable.setColor(rgb);//設置顏色
        gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);//設置顯示的樣式
        gradientDrawable.setCornerRadius(radius);//設置圓角的半徑
        gradientDrawable.setStroke(DensityUtil.dip2px(1),rgb);//描邊

        return gradientDrawable;
    }

    public static StateListDrawable getSelector(Drawable normalDrawable, Drawable pressDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
//給當前的顏色選擇器添加選中圖片指向狀態，未選中圖片指向狀態
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed}, pressDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, normalDrawable);
//設置預設狀態
        stateListDrawable.addState(new int[]{}, normalDrawable);
        return stateListDrawable;
    }

    public static Drawable resetImageBoundsScale(Context mContext, int drawableID, double wScale, double hScale)
    {
        Drawable icon = ContextCompat.getDrawable(mContext, drawableID);
        int WIcon = icon.getIntrinsicWidth();
        int HIcon = icon.getIntrinsicHeight();
        icon.setBounds(0, 0, (int)(WIcon/ wScale), (int)(HIcon/ hScale));

        return icon;
    }

    public static Drawable resetImageSize(Context mContext, int drawableID, int newWidth, int newHeight)
    {
        Drawable image = ContextCompat.getDrawable(mContext, drawableID);
        Bitmap bitmap = ((BitmapDrawable)image).getBitmap();
        Drawable newImage = new BitmapDrawable(mContext.getResources(), Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true));

        return newImage;
    }
}
