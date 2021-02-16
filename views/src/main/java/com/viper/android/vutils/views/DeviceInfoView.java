package com.viper.android.vutils.views;

import android.content.Context;
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
        builder.put("===== ABI =====").lf().lf();
        String[] abis = Build.SUPPORTED_ABIS;
        if (abis != null) {
            for (int i = 0; i < abis.length; ++i) {
                builder.put("CPU ABI").put("" + i).put(" : ").put(abis[i]).lf();
            }
        }

        return builder.build();
    }
}
