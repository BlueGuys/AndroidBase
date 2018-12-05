package com.hongyan.wdcf.business.account.feedback;

public class DeviceInfo {

    private int screenWidth;

    private int screenHeight;

    /**
     * 屏幕密度
     */
    private int densityDpi;

    /**
     * 屏幕基比(这个值代表屏幕到底有多清晰)
     */
    private float density;

    /**
     * 状态栏高度
     */
    private int statusBarHeight;
    /**
     * 虚拟键盘高度
     */
    private int virtualBarHeight;

    /**
     * 系统版本号
     */
    private String systemVersion;

    /**
     * 手机厂商
     */
    private String deviceBrand;

    /**
     * 手机名称
     */
    private String deviceName;


    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getDensityDpi() {
        return densityDpi;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public void setDensityDpi(int densityDpi) {
        this.densityDpi = densityDpi;
    }

    public int getStatusBarHeight() {
        return statusBarHeight;
    }

    public void setStatusBarHeight(int statusBarHeight) {
        this.statusBarHeight = statusBarHeight;
    }

    public int getVirtualBarHeight() {
        return virtualBarHeight;
    }

    public void setVirtualBarHeight(int virtualBarHeight) {
        this.virtualBarHeight = virtualBarHeight;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("设备型号:").append(deviceName).append("\n");
        builder.append("设备厂商:").append(deviceBrand).append("\n");
        builder.append("系统版本:").append(systemVersion).append("\n");
        builder.append("屏幕宽度:").append(screenWidth).append("\n");
        builder.append("屏幕高度:").append(screenHeight).append("\n");
        builder.append("屏幕密度:").append(densityDpi).append("\n");
        builder.append("屏幕基比:").append(density).append("\n");
        builder.append("状态栏高度:").append(statusBarHeight).append("\n");
        builder.append("虚拟按键高度:").append(virtualBarHeight).append("\n");
        return builder.toString();
    }
}
