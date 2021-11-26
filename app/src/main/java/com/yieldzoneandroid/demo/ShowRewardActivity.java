package com.yieldzoneandroid.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yieldzone.ads.YieldzoneAdRewardVideoAd;
import com.yieldzone.baselibrary.YieldzoneLoadAdError;
import com.yieldzone.baselibrary.listeners.RewardedVideoListener;

import static com.yieldzoneandroid.demo.TestPidUtils.YZ_REWARD_VIDEO_ID;

/***
 Created by weiyang

 on 8/10/21 
 Copyright (c) 2021 Yieldzone. All rights reserved.
 ***/
public class ShowRewardActivity extends AppCompatActivity {
    private static final String TAG = com.yieldzoneandroid.demo.ShowBannerActivity.class.getSimpleName();

    private Button show_reward;

    private YieldzoneAdRewardVideoAd mReward;

    public static void start(Context context) {
        Intent intent = new Intent(context, com.yieldzoneandroid.demo.ShowRewardActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_show_reward);
        show_reward = findViewById(R.id.show_reward);
        show_reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoadReward();
            }
        });

    }

    private void showLoadReward() {
        com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowRewardActivity.this, "reward load...");
        mReward = new YieldzoneAdRewardVideoAd(com.yieldzoneandroid.demo.ShowRewardActivity.this,new RewardedVideoListener() {
            @Override
            public void onRewardedVideoAdClosed() {
                Log.d(TAG, "reward onAdClosed()");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowRewardActivity.this, "reward closed...");
            }

            @Override
            public void onRewardedVideoAdExpose() {
                Log.d(TAG, "reward onRewardedVideoAdExpose()");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowRewardActivity.this, "reward expose...");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d(TAG, "reward onAdFailedToLoad()");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowRewardActivity.this, "reward failed...");
            }

            @Override
            public void onAdFailedToLoad(YieldzoneLoadAdError error) {
                Log.d(TAG, "reward onAdFailedToLoad()");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowRewardActivity.this, "reward failed...");
            }

            @Override
            public void onRewardedVideoAdOpened() {
                Log.d(TAG, "reward onAdOpened()");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowRewardActivity.this, "reward open...");
            }

            @Override
            public void onRewardedVideoAdLoaded() {
                Log.d(TAG, "reward onAdLoaded()");
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowRewardActivity.this, "reward load success...");
                mReward.showAd();
            }

            @Override
            public void onRewardedVideoAdClicked() {
                Log.d(TAG, "reward onAdClicked()");
            }

            @Override
            public void onRewardedVideoAdRewarded() {
                com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowRewardActivity.this, "reward rewarded...");
            }


        }, YZ_REWARD_VIDEO_ID);
        mReward.loadAd();
    }
}
