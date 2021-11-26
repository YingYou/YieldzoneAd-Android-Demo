package com.yieldzoneandroid.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yieldzone.ads.YieldzoneAdBannerAd;
import com.yieldzone.baselibrary.AdSize;
import com.yieldzone.baselibrary.YieldzoneLoadAdError;
import com.yieldzone.baselibrary.listeners.BannerAdListener;

import static com.yieldzoneandroid.demo.TestPidUtils.YZ_BANNER_ID;


public class ShowBannerActivity extends AppCompatActivity {
    private static final String TAG = com.yieldzoneandroid.demo.ShowBannerActivity.class.getSimpleName();

    private YieldzoneAdBannerAd bannerAd1;

    public static void start(Context context) {
        Intent intent = new Intent(context, com.yieldzoneandroid.demo.ShowBannerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_banner);
        //banner广告
        FrameLayout container = findViewById(R.id.adContainer);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner load...");
                bannerAd1 =  new YieldzoneAdBannerAd(com.yieldzoneandroid.demo.ShowBannerActivity.this,new BannerAdListener() {
                    @Override
                    public void onBannerAdClosed() {
                        Log.d(TAG, "关闭广告");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner close...");
                    }

                    @Override
                    public void onBannerAdExpose() {
                        Log.d(TAG, "广告Expose");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner expose...");
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onAdFailedToLoad(YieldzoneLoadAdError error) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onBannerAdOpened() {
                        Log.d(TAG, "展示广告opoen");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner opened...");
                    }

                    @Override
                    public void onBannerAdLoaded() {
                        Log.d(TAG, "广告加载成功");
                        bannerAd1.showBanner(container);
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner load success...");
                    }

                    @Override
                    public void onBannerAdClicked() {
                        Log.d(TAG, "广告被点击");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner click...");
                    }

                }, YZ_BANNER_ID, AdSize.BANNER_320_50);//3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
                bannerAd1.loadAd();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bannerAd1 =  new YieldzoneAdBannerAd(com.yieldzoneandroid.demo.ShowBannerActivity.this,new BannerAdListener() {
                    @Override
                    public void onBannerAdClosed() {
                        Log.d(TAG, "关闭广告");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner close...");
                    }

                    @Override
                    public void onBannerAdExpose() {
                        Log.d(TAG, "广告Expose");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner expose...");
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onAdFailedToLoad(YieldzoneLoadAdError error) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onBannerAdOpened() {
                        Log.d(TAG, "展示广告opoen");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner opened...");
                    }

                    @Override
                    public void onBannerAdLoaded() {
                        Log.d(TAG, "广告加载成功");
                        bannerAd1.showBanner(container);
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner load success...");
                    }

                    @Override
                    public void onBannerAdClicked() {
                        Log.d(TAG, "广告被点击");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner click...");
                    }

                }, YZ_BANNER_ID, AdSize.BANNER_320_100);//3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
                bannerAd1.loadAd();
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bannerAd1 =  new YieldzoneAdBannerAd(com.yieldzoneandroid.demo.ShowBannerActivity.this,new BannerAdListener() {
                    @Override
                    public void onBannerAdClosed() {
                        Log.d(TAG, "关闭广告");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner close...");
                    }

                    @Override
                    public void onBannerAdExpose() {
                        Log.d(TAG, "广告Expose");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner expose...");
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onAdFailedToLoad(YieldzoneLoadAdError error) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onBannerAdOpened() {
                        Log.d(TAG, "展示广告opoen");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner opened...");
                    }

                    @Override
                    public void onBannerAdLoaded() {
                        Log.d(TAG, "广告加载成功");
                        bannerAd1.showBanner(container);
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner load success...");
                    }

                    @Override
                    public void onBannerAdClicked() {
                        Log.d(TAG, "广告被点击");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner click...");
                    }

                }, YZ_BANNER_ID, AdSize.BANNER_320_250);//3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
                bannerAd1.loadAd();
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bannerAd1 =  new YieldzoneAdBannerAd(com.yieldzoneandroid.demo.ShowBannerActivity.this,new BannerAdListener() {
                    @Override
                    public void onBannerAdClosed() {
                        Log.d(TAG, "关闭广告");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner close...");
                    }

                    @Override
                    public void onBannerAdExpose() {
                        Log.d(TAG, "广告Expose");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner expose...");
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onAdFailedToLoad(YieldzoneLoadAdError error) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onBannerAdOpened() {
                        Log.d(TAG, "展示广告opoen");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner opened...");
                    }

                    @Override
                    public void onBannerAdLoaded() {
                        Log.d(TAG, "广告加载成功");
                        bannerAd1.showBanner(container);
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner load success...");
                    }

                    @Override
                    public void onBannerAdClicked() {
                        Log.d(TAG, "广告被点击");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner click...");
                    }

                }, YZ_BANNER_ID, AdSize.BANNER_468_60);//3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
                bannerAd1.loadAd();
            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bannerAd1 =  new YieldzoneAdBannerAd(com.yieldzoneandroid.demo.ShowBannerActivity.this,new BannerAdListener() {
                    @Override
                    public void onBannerAdClosed() {
                        Log.d(TAG, "关闭广告");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner close...");
                    }

                    @Override
                    public void onBannerAdExpose() {
                        Log.d(TAG, "广告Expose");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner expose...");
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onAdFailedToLoad(YieldzoneLoadAdError error) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onBannerAdOpened() {
                        Log.d(TAG, "展示广告opoen");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner opened...");
                    }

                    @Override
                    public void onBannerAdLoaded() {
                        Log.d(TAG, "广告加载成功");
                        bannerAd1.showBanner(container);
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner load success...");
                    }

                    @Override
                    public void onBannerAdClicked() {
                        Log.d(TAG, "广告被点击");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner click...");
                    }

                }, YZ_BANNER_ID, AdSize.BANNER_728_90);//3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
                bannerAd1.loadAd();
            }
        });

        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bannerAd1 =  new YieldzoneAdBannerAd(com.yieldzoneandroid.demo.ShowBannerActivity.this,new BannerAdListener() {
                    @Override
                    public void onBannerAdClosed() {
                        Log.d(TAG, "关闭广告");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner close...");
                    }

                    @Override
                    public void onBannerAdExpose() {
                        Log.d(TAG, "广告Expose");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner expose...");
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onAdFailedToLoad(YieldzoneLoadAdError error) {
                        Log.d(TAG, "加载失败");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner failed...");
                    }

                    @Override
                    public void onBannerAdOpened() {
                        Log.d(TAG, "展示广告opoen");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner opened...");
                    }

                    @Override
                    public void onBannerAdLoaded() {
                        Log.d(TAG, "广告加载成功");
                        bannerAd1.showBanner(container);
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner load success...");
                    }

                    @Override
                    public void onBannerAdClicked() {
                        Log.d(TAG, "广告被点击");
                        YZToast.show(com.yieldzoneandroid.demo.ShowBannerActivity.this, "banner click...");
                    }

                }, YZ_BANNER_ID, AdSize.BANNER_320_90);//3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
                bannerAd1.loadAd();
            }
        });
    }
}
