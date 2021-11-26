package com.yieldzoneandroid.demo;


import androidx.multidex.MultiDexApplication;

import com.yieldzone.baselibrary.Error;
import com.yieldzone.baselibrary.listeners.OnInitializationCompleteListener;
import com.yieldzone.library.YieldzoneAdApi;

import static com.yieldzoneandroid.demo.TestPidUtils.YZ_APP_ID;


public class TestApplication extends MultiDexApplication {
    private static final String TAG = com.yieldzoneandroid.demo.TestApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        YieldzoneAdApi.setGDPRConsent(true);
        YieldzoneAdApi.init(this,YZ_APP_ID, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(Error error) {

            }

        });
    }
}
