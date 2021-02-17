package com.viper.android.vutils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.viper.android.vutils.system.SystemUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SystemUtils.openAppSettings(this);
    }
}