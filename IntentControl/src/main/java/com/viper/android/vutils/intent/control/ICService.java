package com.viper.android.vutils.intent.control;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class ICService extends IntentService {

    public ICService() {
        super("IntentControlService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
