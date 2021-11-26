package com.yieldzoneandroid.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yieldzone.ads.YieldzoneAdInterstitialAd;
import com.yieldzone.baselibrary.AdSize;
import com.yieldzone.baselibrary.YieldzoneLoadAdError;
import com.yieldzone.baselibrary.listeners.InterstitialAdListener;

import static com.yieldzoneandroid.demo.TestPidUtils.YZ_INTERSTITIAL_ID;

/***
 Created by weiyang

 on 8/10/21 
 Copyright (c) 2021 Yieldzone. All rights reserved.
 ***/
public class ShowInterstitialActivity extends AppCompatActivity {

    private static final String TAG = com.yieldzoneandroid.demo.ShowInterstitialActivity.class.getSimpleName();

    private Button show_interstitial;

    private YieldzoneAdInterstitialAd mIntersitial;

    public int dip2px(float dipValue) {
        float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    public static void start(Context context) {
        Intent intent = new Intent(context, com.yieldzoneandroid.demo.ShowInterstitialActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_show_interstitial);
        show_interstitial = findViewById(R.id.show_interstitial);
        show_interstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoadInterstitial();
            }
        });
    }

    private void showLoadInterstitial() {
        int padding = dip2px(10);
        final int containerHeight = dip2px(340);
        final int adViewWidth = getResources().getDisplayMetrics().widthPixels - 2 * padding;
        final int adViewHeight = adViewWidth * 2;

        com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowInterstitialActivity.this, "Interstitial load...");
        mIntersitial = new YieldzoneAdInterstitialAd(com.yieldzoneandroid.demo.ShowInterstitialActivity.this,new InterstitialAdListener() {
            @Override
            public void onInterstitialAdClosed() {
                Log.d(TAG, "关闭插屏广告");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowInterstitialActivity.this, "Interstitial close...");
            }

            @Override
            public void onInterstitialAdExpose() {
                Log.d(TAG, "插屏广告Expose");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowInterstitialActivity.this, "Interstitial Expose...");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d(TAG, "加载插屏广告失败");
            }

            @Override
            public void onAdFailedToLoad(YieldzoneLoadAdError error) {
                Log.d(TAG, "加载插屏广告失败");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowInterstitialActivity.this, "Interstitial error..."+error.errorCode);
            }

            @Override
            public void onInterstitialAdOpened() {
                Log.d(TAG, "展示插屏广告");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowInterstitialActivity.this, "Interstitial open...");
            }

            @Override
            public void onInterstitialAdLoaded() {
                Log.d(TAG, "加载插屏广告成功");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowInterstitialActivity.this, "Interstitial load success...");
                mIntersitial.showAd();
            }

            @Override
            public void onInterstitialAdClicked() {
                Log.d(TAG, "点击插屏广告");
            }

        }, YZ_INTERSTITIAL_ID,new AdSize(adViewWidth,adViewHeight));
        mIntersitial.loadAd();
    }
}
