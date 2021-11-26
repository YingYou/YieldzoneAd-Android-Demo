package com.yieldzoneandroid.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.yieldzone.ads.YieldzoneAdSplashAd;
import com.yieldzone.baselibrary.YieldzoneLoadAdError;
import com.yieldzone.baselibrary.listeners.SplashAdListener;

import static com.yieldzoneandroid.demo.TestPidUtils.YZ_SPLASH_ID;

public class SplashAdActivity extends Activity {

    private Button show_splash;

    private static final String TAG = com.yieldzoneandroid.demo.SplashAdActivity.class.getSimpleName();

    private YieldzoneAdSplashAd mSplash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_splash);
        show_splash = findViewById(R.id.show_splash);
        show_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoadSplash();
            }
        });
    }

    private void showLoadSplash(){

        com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.SplashAdActivity.this, "splash load...");
        mSplash = new YieldzoneAdSplashAd(com.yieldzoneandroid.demo.SplashAdActivity.this,new SplashAdListener() {
            @Override
            public void onSplashAdDismissed() {
                Log.d(TAG, "onAdClosed()");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.SplashAdActivity.this, "splash close...");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d(TAG, "onAdFailedToLoad()");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.SplashAdActivity.this, "splash error...");
            }

            @Override
            public void onAdFailedToLoad(YieldzoneLoadAdError error) {
                Log.d(TAG, "onAdFailedToLoad()");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.SplashAdActivity.this, "splash error2...");
            }

            @Override
            public void onSplashAdShowed() {
                Log.d(TAG, "onAdOpened()");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.SplashAdActivity.this, "splash show...");
            }

            @Override
            public void onSplashAdLoad() {
                Log.d(TAG, "onAdLoaded()");
                mSplash.showAd();
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.SplashAdActivity.this, "splash load...");
            }

            @Override
            public void onSplashAdClicked() {
                Log.d(TAG, "onAdClicked()");
            }

        }, YZ_SPLASH_ID);
        mSplash.loadAd();
    }
}
