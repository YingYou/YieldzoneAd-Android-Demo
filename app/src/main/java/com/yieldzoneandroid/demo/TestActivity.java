package com.yieldzoneandroid.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yieldzone.base.YieldzoneDebugSettings;
import com.yieldzone.baselibrary.utils.AppUtils;
import com.yieldzone.baselibrary.utils.NetworkUtils;
import com.yieldzone.baselibrary.utils.PhoneUtils;
import com.yieldzone.baselibrary.utils.ScreenUtils;
import com.yieldzone.library.YieldzoneAdApi;

import org.json.JSONException;
import org.json.JSONObject;


public class TestActivity extends AppCompatActivity {
    private final static String TAG = "SparkXSdk";

    public int dip2px(float dipValue) {
        float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int padding = dip2px(10);
        final int containerHeight = dip2px(340);
        final int adViewWidth = getResources().getDisplayMetrics().widthPixels - 2 * padding;
        final int adViewHeight = adViewWidth * 2;

        TextView textView = this.findViewById(R.id.sdk_version);
        textView.setText("SDK Version"+ YieldzoneAdApi.sdkVersion());

        findViewById(R.id.show_interstitial).setOnClickListener(v -> {
            Log.d("AdMobAgent", "interstitial clicked");

          com.yieldzoneandroid.demo.ShowInterstitialActivity.start(com.yieldzoneandroid.demo.TestActivity.this);
        });

        //banner广告
        FrameLayout container = findViewById(R.id.bannerContainer);
        findViewById(R.id.show_banner).setOnClickListener(v -> {
            Log.d(TAG, "show banner clicked");
            //container.setVisibility(View.GONE);
            //SparkXSDK.showBanner(TestActivity.this, container, AdSize.BANNER_HEIGHT_90);
            com.yieldzoneandroid.demo.ShowBannerActivity.start(com.yieldzoneandroid.demo.TestActivity.this);
        });

        findViewById(R.id.show_native).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.yieldzoneandroid.demo.ShowNativeActivity.start(com.yieldzoneandroid.demo.TestActivity.this);
                //ShowOwnerNativeAdActivity.start(TestActivity.this);
            }
        });

        findViewById(R.id.show_reward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //激励广告

                com.yieldzoneandroid.demo.ShowRewardActivity.start(com.yieldzoneandroid.demo.TestActivity.this);
            }
        });

        findViewById(R.id.show_video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.yieldzoneandroid.demo.ShowDrawVideoActivity.start(com.yieldzoneandroid.demo.TestActivity.this);
            }
        });


        //网络请求
        findViewById(R.id.splash_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(com.yieldzoneandroid.demo.TestActivity.this, com.yieldzoneandroid.demo.SplashAdActivity.class);
               startActivity(intent);
            }
        });

        //打开工程模式
        findViewById(R.id.open_debug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), DebugSettingsActivity.class));
                Intent intent = new Intent(getApplicationContext(), YieldzoneDebugSettings.class);
                startActivity(intent);
            }
        });
    }

//    public void getAdResource(StringRequestListener listener) {
//        String url = "http://121.4.209.79:19004/client/req_ad";
//        AndroidNetworking.post(url)
//                .addJSONObjectBody(getPostParams())
//                .setTag("test_ad")
//                .setPriority(Priority.LOW)
//                .build()
//                //.setAnalyticsListener(getAnalyticsListener("getAdResource"))
//                .getAsString(listener);
//    }

    private int getNetworkingType(NetworkUtils.NetworkType type) {
        switch (type) {
            case NETWORK_2G:
                return 5;
            case NETWORK_3G:
                return 4;
            case NETWORK_4G:
                return 3;
            case NETWORK_5G:
                return 2;
            case NETWORK_WIFI:
                return 1;
            default:
                return -1;
        }
    }

    private JSONObject getPostParams() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("version", "1.0");
            jsonObject.put("pid", "234234234");
            jsonObject.put("is_mobile", 1);
            jsonObject.put("app_package", AppUtils.getAppPackageName());
            jsonObject.put("app_id", "test12445");
            jsonObject.put("app_name", AppUtils.getAppName());
            jsonObject.put("app_ver", AppUtils.getAppVersionCode()+"");
            jsonObject.put("device_imei", PhoneUtils.getAndroidId());
            jsonObject.put("device_adid", PhoneUtils.getAndroidId());
            jsonObject.put("device_ppi", ScreenUtils.getScreenDensityDpi()+"");
            jsonObject.put("device_mac", NetworkUtils.getDeviceMac());
            jsonObject.put("device_type_os", PhoneUtils.getSystemOS());
            jsonObject.put("device_type", 0);
            jsonObject.put("device_brand", PhoneUtils.getDeviceBrand());
            jsonObject.put("device_model", PhoneUtils.getSystemModel());
            jsonObject.put("device_width", ScreenUtils.getScreenWidth());
            jsonObject.put("device_height", ScreenUtils.getScreenHeight());
            jsonObject.put("device_network", getNetworkingType(NetworkUtils.getNetworkType()));
            jsonObject.put("device_os", "Android");
            jsonObject.put("device_orientation", 0);
            jsonObject.put("device_lan", PhoneUtils.getSystemLanguage());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
