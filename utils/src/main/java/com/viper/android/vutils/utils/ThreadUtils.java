package com.viper.android.vutils.utils;

import android.os.Handler;
import android.os.HandlerThread;

public final class ThreadUtils {

    private ThreadUtils() {
    }

    public static HandlerThread newHandlerThread(String name, int priority) {
        HandlerThread thread = new HandlerThread(name, priority);
        thread.start();
        return thread;
    }

    public static Handler newHandler(String name, int priority) {
        HandlerThread thread = newHandlerThread(name, priority);
        return new Handler(thread.getLooper());
    }
}
