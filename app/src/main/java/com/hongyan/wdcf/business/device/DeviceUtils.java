package com.hongyan.wdcf.business.device;


import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Method;
import java.util.Locale;

public class DeviceUtils {

    private static volatile DeviceUtils instance;

    private static Context mContext;

    private DeviceInfo deviceInfo = new DeviceInfo();

    private DeviceUtils() {
    }

    public static DeviceUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (DeviceUtils.class) {
                if (instance == null) {
                    instance = new DeviceUtils();
                    mContext = context;
                }
            }
        }
        return instance;
    }

    public DeviceInfo exec() {
        displayInfo();
        deviceInfo.setStatusBarHeight(getStatusBarHeight());
        deviceInfo.setVirtualBarHeight(getVirtualBarHeigh());
        deviceInfo.setDeviceName(getSystemModel());
        deviceInfo.setDeviceBrand(getDeviceBrand());
        deviceInfo.setSystemVersion(getSystemVersion());
        return deviceInfo;
    }

    /**
     * 获取屏幕分辨率
     * vivoX21(1080,2208)
     */
    private void displayInfo() {
        int width = 0;
        int height = 0;
        int densityDpi = 0;
        float density = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getRealMetrics(dm);
                width = dm.widthPixels;
                height = dm.heightPixels;
                densityDpi = dm.densityDpi;
                density = dm.density;
            }
        } else {
            DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
            width = dm.widthPixels;
            height = dm.heightPixels;
            densityDpi = dm.densityDpi;
            density = dm.density;
        }
        deviceInfo.setScreenWidth(width);
        deviceInfo.setScreenHeight(height);
        deviceInfo.setDensityDpi(densityDpi);
        deviceInfo.setDensity(density);
    }


    /**
     * 获取状态栏的高度
     */
    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取虚拟功能键高度
     */
    public static int getVirtualBarHeigh() {
        int vh = 0;
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        try {
            @SuppressWarnings("rawtypes")
            Class c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            vh = dm.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vh;
    }

    /**
     * 获取当前手机系统语言。
     *
     * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前系统上的语言列表(Locale列表)
     *
     * @return 语言列表
     */
    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机IMEI(需要“android.permission.READ_PHONE_STATE”权限)
     *
     * @return 手机IMEI
     */
    public static String getIMEI(Context ctx) {
//        TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Activity.TELEPHONY_SERVICE);
//        if (tm != null) {
//            return tm.getDeviceId();
//        }
        return null;
    }

    public static int getRealDimen(int x) {
        int y = 0;
        int uiWidth = 750;
        int screenWidth = 1080;
        double ratio = uiWidth / screenWidth;
        return (int) Math.round(y * ratio);
    }

}
