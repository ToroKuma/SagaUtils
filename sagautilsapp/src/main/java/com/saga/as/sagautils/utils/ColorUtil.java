package tw.com.as.sagautils.utils;

import android.graphics.Color;

/**
 * Created by AS on 2016/7/13.
 */
public class ColorUtil {
    public static int getDarkerColor(int color){
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv); // convert to hsv
        // make darker
        hsv[1] = hsv[1] + 0.1f; // more saturation
        hsv[2] = hsv[2] - 0.1f; // less brightness
        int darkerColor = Color.HSVToColor(hsv);
        return  darkerColor ;
    }

    public static int getDarkerColor(int color, float s){
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv); // convert to hsv
        // make darker
        hsv[1] = hsv[1] + s; // more saturation
        hsv[2] = hsv[2] - s; // less brightness
        int darkerColor = Color.HSVToColor(hsv);
        return  darkerColor ;
    }

    public static int getBrighterColor(int color){
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv); // convert to hsv

        hsv[1] = hsv[1] - 0.1f; // less saturation
        hsv[2] = hsv[2] + 0.1f; // more brightness
        int brighterColor = Color.HSVToColor(hsv);
        return  brighterColor ;
    }

    public static int getBrighterColor(int color, float s){
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv); // convert to hsv

        hsv[1] = hsv[1] - s; // less saturation
        hsv[2] = hsv[2] + s; // more brightness
        int brighterColor = Color.HSVToColor(hsv);
        return  brighterColor ;
    }
}
