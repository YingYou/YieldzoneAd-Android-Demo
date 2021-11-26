package com.yieldzoneandroid.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.yieldzone.baselibrary.YieldzoneLoadAdError;
import com.yieldzone.baselibrary.listeners.VideoAdListener;
import com.yieldzone.library.YieldzoneAdApi;

import static com.yieldzoneandroid.demo.TestPidUtils.YZ_DRAW_VIDEO_ID;

/***
 Created by weiyang

 on 8/10/21 
 Copyright (c) 2021 Yieldzone. All rights reserved.
 ***/
public class ShowDrawVideoActivity extends Activity {

    private static final String TAG = SplashAdActivity.class.getSimpleName();

    private Button show_drawvideo;

    public static void start(Context context) {
        Intent intent = new Intent(context, com.yieldzoneandroid.demo.ShowDrawVideoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_show_drawvideo);
        show_drawvideo = findViewById(R.id.show_drawvideo);
        show_drawvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoadDrawVideo();
            }
        });

    }

    private void showLoadDrawVideo() {
        YieldzoneAdApi.loadVideo(new VideoAdListener() {
            @Override
            public void onAdClosed() {

            }

            @Override
            public void onUserEarnedReward() {

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

            }

            @Override
            public void onAdFailedToLoad(YieldzoneLoadAdError error) {

            }

            @Override
            public void onAdOpened() {

            }

            @Override
            public void onAdLoaded() {
                YieldzoneAdApi.showVideo();
            }

            @Override
            public void onAdClicked() {

            }

        }, YZ_DRAW_VIDEO_ID);
    }
}
