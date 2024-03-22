package com.viper.android.vutils.intent.control;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class RemoteControlService extends IntentService {

    public RemoteControlService() {
        super("RemoteControlService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
