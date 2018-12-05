package com.hongyan.wdcf.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.hongyan.ToastsUtils;
import com.hongyan.base.BaseApplication;
import com.hongyan.wdcf.business.account.core.AccountManager;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.lang.reflect.Method;

/**
 * Created by wangning on 2018/6/10.
 */

public class WDApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
        AccountManager.getInstance().init();
        ImageLoaderOptionHelper.getInstance().initImageLoader(this);
        ToastsUtils.register(this);
        UMConfigure.init(this, "5b6fd8b8a40fa3274c00039c", "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        PlatformConfig.setWeixin("wx1341921c649344b5", "f6435d2f326a5be7ca174c3490280d2f");
        PlatformConfig.setQQZone("1107393925", "eED7IKonDsTw2e7E");
        UMConfigure.setLogEnabled(true);
        UMShareAPI.get(this);
        displayInfo(this);
        Log.e("DisplayUtil", checkDeviceHasNavigationBar(this) ? "展示" : "不展示");
        Log.e("DisplayUtil", "高度:" + getVirtualBarHeigh(this));

    }

    /**
     * 获取屏幕分辨率
     * vivoX21(1080,2208)
     */
    private void displayInfo(Context context) {
        if (context == null) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        int width = 0;
        int height = 0;
        int density = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getRealMetrics(dm);
                width = dm.widthPixels;
                height = dm.heightPixels;
                density = dm.densityDpi;
            }
        } else {
            DisplayMetrics dm = getResources().getDisplayMetrics();
            width = dm.widthPixels;
            height = dm.heightPixels;
            density = dm.densityDpi;
        }
        builder.append("屏幕宽高:[").append(width).append(",").append(height).append("]\n");
        builder.append("屏幕密度:").append(density).append("\n");
        Log.e("DisplayUtil", builder.toString());
    }

    /**
     * 获取是否存在NavigationBar
     *
     * @param context
     * @return
     */
    public boolean checkDeviceHasNavigationBar(Context context) {
        boolean hasNavigationBar = false;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {
        }
        return hasNavigationBar;
    }

    /**
     * 获取虚拟功能键高度
     *
     * @param context
     * @return
     */
    public int getVirtualBarHeigh(Context context) {
        int vh = 0;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
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


    private void initRouter() {
        RouterConfig.getInstance().init();
    }
}
