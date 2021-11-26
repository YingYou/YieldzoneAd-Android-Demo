package com.yieldzoneandroid.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.facebook.samples.ads.debugsettings.DebugSettingsActivity
import com.yieldzone.ads.YieldzoneAdInterstitialAd
import com.yieldzone.ads.YieldzoneAdRewardVideoAd
import com.yieldzone.baselibrary.AdSize
import com.yieldzone.baselibrary.YieldzoneLoadAdError
import com.yieldzone.baselibrary.listeners.InterstitialAdListener
import com.yieldzone.baselibrary.listeners.RewardedVideoListener
import com.yieldzone.baselibrary.listeners.VideoAdListener
import com.yieldzone.library.YieldzoneAdApi
import com.yieldzoneandroid.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"

    fun dip2px(dipValue: Float): Int {
        val scale = this.resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sdk_version.text = "SDK Version"+ YieldzoneAdApi.sdkVersion()

        val padding: Int = dip2px(10f)
        val containerHeight: Int = dip2px(340f)
        val adViewWidth = resources.displayMetrics.widthPixels - 2 * padding
        val adViewHeight = adViewWidth * 2
        show_interstitial.setOnClickListener {
            //插屏广告
           ShowInterstitialActivity.start(this)
            //SparkXSDK.showInterstitial()
        }

        show_banner.setOnClickListener {
            //展示banner
            Log.d(TAG, "展示banner")
            //SparkXSDK.showBanner(this, bannerContainer);
            ShowBannerActivity.start(this)
        }

        show_native.setOnClickListener {
            //展示native
            Log.d(TAG, "展示native")
            ShowNativeActivity.start(this)
        }

        show_video.setOnClickListener {
            ShowDrawVideoActivity.start(this)
        }

        show_splash.setOnClickListener {
            //展示splash
            Log.d(TAG, "展示splash")
            SplashAdActivity.start(this)

        }

        show_reward.setOnClickListener {
            Log.d(TAG, "展示激励视频")
            ShowRewardActivity.start(this)

        }

        debug_facebook_btn.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    DebugSettingsActivity::class.java
                )
            )
        }
    }
}