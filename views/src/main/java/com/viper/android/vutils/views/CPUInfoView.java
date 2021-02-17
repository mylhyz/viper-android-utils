package com.viper.android.vutils.views;

import android.content.Context;
import android.util.AttributeSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CPUInfoView extends AbsInfoView {

    public CPUInfoView(Context context) {
        super(context);
    }

    public CPUInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CPUInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onInit(Context context) {

    }

    @Override
    public String onGetInfo(Context context) {
        Builder builder = new Builder();
        builder.put("===== CPU =====").lf().lf();
        builder.put(getCpuInfo());
        return builder.build();
    }


    // 获取CPU信息 参考自执行 cat /proc/cpuinfo
    public static String getCpuInfo() {
        try {
            FileReader fr = new FileReader("/proc/cpuinfo");
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
