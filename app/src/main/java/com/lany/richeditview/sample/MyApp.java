package com.lany.richeditview.sample;

import android.app.Application;

import com.lany.box.Box;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Box.of().init(this);
    }
}
