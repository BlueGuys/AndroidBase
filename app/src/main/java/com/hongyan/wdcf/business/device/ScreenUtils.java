package com.hongyan.wdcf.business.device;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.hongyan.wdcf.base.WDApplication;

public class ScreenUtils {

    private static final float UI_WIDTH = 750;
    private static float screenWidth = 0;

    static {
        Context context = WDApplication.getInstance().getApplicationContext();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getRealMetrics(dm);
                screenWidth = dm.widthPixels;
            }
        } else {
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            screenWidth = dm.widthPixels;
        }
    }

    public static int getRealDimen(int x) {
        double ratio = screenWidth / UI_WIDTH;
        return (int) Math.round(x * ratio);
    }

}
