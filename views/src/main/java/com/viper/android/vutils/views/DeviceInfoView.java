package com.viper.android.vutils.views;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.AttributeSet;

public class DeviceInfoView extends AbsInfoView {

    public DeviceInfoView(Context context) {
        super(context);
    }

    public DeviceInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DeviceInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onInit(Context context) {

    }

    @Override
    public String onGetInfo(Context context) {
        Builder builder = new Builder();
        builder.put("===== INFO =====").lf().lf();
        builder.put(Build.BRAND).put(" ").put(Build.MODEL).put(" (").put(Build.PRODUCT).put(")").lf();
        builder.put("版本号").put(" : ").put(Build.VERSION.RELEASE).put(" - API").put(Build.VERSION.SDK_INT).lf();
        builder.put("设备宽度").put(" : ").put(getDeviceWidth(context)).lf();
        builder.put("设备高度").put(" : ").put(getDeviceHeight(context)).lf();
        builder.lf();
        builder.put("===== ABI =====").lf().lf();
        String[] abis = Build.SUPPORTED_ABIS;
        if (abis != null) {
            for (int i = 0; i < abis.length; ++i) {
                builder.put("CPU ABI").put("" + i).put(" : ").put(abis[i]).lf();
            }
        }
        builder.lf();
        builder.put("===== NETWORK ======").lf().lf();
        builder.put("IP").put(" : ").put(getLocalIPAddress(context)).lf();
        return builder.build();
    }

    /**
     * 获取设备宽度（px）
     */
    public static int getDeviceWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取设备高度（px）
     */
    public static int getDeviceHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    // wifi下获取本地网络IP地址（局域网地址）
    public static String getLocalIPAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null) {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int ipAddress = wifiInfo.getIpAddress();
            return (ipAddress & 0xff) + "." + (ipAddress >> 8 & 0xff) + "." + (ipAddress >> 16 & 0xff) + "." + (ipAddress >> 24 & 0xff);
        }
        return "none";
    }
}
