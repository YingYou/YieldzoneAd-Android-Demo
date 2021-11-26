package com.yieldzoneandroid.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yieldzone.ads.LogoView;
import com.yieldzone.ads.MediaView;

public class ShowOwnerNativeAdActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, com.yieldzoneandroid.demo.ShowOwnerNativeAdActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_owner_native);
        MediaView mediaView = findViewById(R.id.mediaView);
        LogoView logoView = findViewById(R.id.logoView);
        //mediaView.loadVideo("https://jzvd.nathen.cn/video/cfe6c30-1767b1bc21f-0007-1823-c86-de200.mp4");
        logoView.loadLogo(R.drawable.ic_ad_logo_01);
    }
}
