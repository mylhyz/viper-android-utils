package com.viper.android.vutils.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;

public final class Dispatcher {

    private Dispatcher() {
    }

    private static final Handler sMainHandler = new Handler(Looper.getMainLooper());
    private static final Handler sBackgroundHandler = ThreadUtils.newHandler("viper-background-dispatcher", Process.THREAD_PRIORITY_BACKGROUND);
    private static final Handler sIoHandler = ThreadUtils.newHandler("viper-io-dispatcher", Process.THREAD_PRIORITY_BACKGROUND);

    public static Handler main() {
        return sMainHandler;
    }

    public static Handler background() {
        return sBackgroundHandler;
    }

    public static Handler io() {
        return sIoHandler;
    }
}
