package com.yieldzoneandroid.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.yieldzone.ads.YieldzoneNativeExpressAd;
import com.yieldzone.baselibrary.AdSize;
import com.yieldzone.baselibrary.YieldzoneLoadAdError;
import com.yieldzone.baselibrary.YieldzoneNativeCardType;
import com.yieldzone.baselibrary.listeners.NativeAdListener;

import static com.yieldzoneandroid.demo.TestPidUtils.YZ_NATIVE_ID;

public class ShowNativeActivity extends AppCompatActivity {
    private static final String TAG = com.yieldzoneandroid.demo.ShowNativeActivity.class.getSimpleName();
    private FrameLayout container;
    private Button show_native;
    private YieldzoneNativeExpressAd mNative;

    public int dip2px(float dipValue) {
        float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, com.yieldzoneandroid.demo.ShowNativeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_native);
        container = findViewById(R.id.native_container);
        show_native = findViewById(R.id.show_native);

        show_native.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container.removeAllViews();
                showLoadNative();
            }
        });

       }

       private void  showLoadNative() {
           int padding = dip2px(10);
           final int containerHeight = dip2px(340);
           final int adViewWidth = getResources().getDisplayMetrics().widthPixels - 2 * padding;
           final int adViewHeight = adViewWidth;

           ConstraintLayout.LayoutParams linearParams =(ConstraintLayout.LayoutParams) container.getLayoutParams();
           linearParams.height = adViewHeight;
           linearParams.width = adViewWidth;
           container.setLayoutParams(linearParams);

           com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowNativeActivity.this, "native load...");
           mNative = new YieldzoneNativeExpressAd(com.yieldzoneandroid.demo.ShowNativeActivity.this,new NativeAdListener() {
               @Override
               public void onNativeAdClosed() {
                   Log.d(TAG, "广告被关闭");
                   com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowNativeActivity.this, "native close...");
               }

               @Override
               public void onAdFailedToLoad(int errorCode) {
                   Log.d(TAG, "广告加载失败");
                   com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowNativeActivity.this, "errorCode..."+errorCode);
               }

               @Override
               public void onAdFailedToLoad(YieldzoneLoadAdError error) {
                   Log.d(TAG, "广告加载失败");
                   com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowNativeActivity.this, "YieldzoneLoadAdError..."+error);
               }

               @Override
               public void onNativeAdOpened() {
                   Log.d(TAG, "广告被展示");
                   com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowNativeActivity.this, "native open...");
               }

               @Override
               public void onNativeAdExpose() {

               }

               @Override
               public void onNativeAdLoaded() {
                   Log.d(TAG, "广告加载成功");
                   com.yieldzoneandroid.demo.YZToast.show(com.yieldzoneandroid.demo.ShowNativeActivity.this, "广告加载成功...");
                   mNative.showAd( container);
               }

               @Override
               public void onNativeAdClicked() {
                   Log.d(TAG, "广告被点击");
               }


           }, YZ_NATIVE_ID, new AdSize(adViewWidth,adViewHeight), YieldzoneNativeCardType.YieldzoneNativeExpressTopMediaBottomText);//3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-4

           mNative.loadAd();
       }
}
