package com.viper.android.vutils.utils;

import android.content.Context;

public class DensityUtils {

    public static float dp2px(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().scaledDensity + 0.5F;
    }
}
