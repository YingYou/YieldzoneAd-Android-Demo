package com.yieldzoneandroid.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yieldzone.ads.YieldzoneAdInterstitialAd
import com.yieldzone.baselibrary.AdSize
import com.yieldzone.baselibrary.YieldzoneLoadAdError
import com.yieldzone.baselibrary.listeners.InterstitialAdListener
import com.yieldzoneandroid.myapplication.R

/***
Created by weiyang

on 8/10/21
Copyright (c) 2021 Yieldzone. All rights reserved.
 ***/
public class ShowInterstitialActivity : AppCompatActivity(){

    val TAG: String =
        ShowInterstitialActivity::class.java.getSimpleName()

    var show_interstitial: Button? = null

    var mIntersitial: YieldzoneAdInterstitialAd? = null

    fun dip2px(dipValue: Float): Int {
        val scale: Float = this.getResources().getDisplayMetrics().density
        return (dipValue * scale + 0.5f).toInt()
    }

    companion object {
    fun start(context: Context) {
        val intent =
            Intent(context, ShowInterstitialActivity::class.java)
        context.startActivity(intent)
    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ad_show_interstitial)
        show_interstitial = findViewById<Button>(R.id.show_interstitial)
        show_interstitial!!.setOnClickListener { showLoadInterstitial() }
    }

    open fun showLoadInterstitial() {
        val padding = dip2px(10f)
        val containerHeight = dip2px(340f)
        val adViewWidth: Int = getResources().getDisplayMetrics().widthPixels - 2 * padding
        val adViewHeight = adViewWidth * 2

        YZToast.show(this@ShowInterstitialActivity, "Interstitial load...")
        mIntersitial = YieldzoneAdInterstitialAd(this@ShowInterstitialActivity,
            object : InterstitialAdListener {
                override fun onInterstitialAdClosed() {
                    Log.d(TAG, "关闭插屏广告")
                    YZToast.show(this@ShowInterstitialActivity, "Interstitial close...")
                }

                override fun onInterstitialAdExpose() {
                    Log.d(TAG, "插屏广告Expose")
                    YZToast.show(this@ShowInterstitialActivity, "Interstitial Expose...")
                }

                override fun onAdFailedToLoad(errorCode: Int) {
                    Log.d(TAG, "加载插屏广告失败")
                }

                override fun onAdFailedToLoad(error: YieldzoneLoadAdError) {
                    Log.d(TAG, "加载插屏广告失败")
                    YZToast.show(
                        this@ShowInterstitialActivity,
                        "Interstitial error..." + error.errorCode
                    )
                }

                override fun onInterstitialAdOpened() {
                    Log.d(TAG, "展示插屏广告")
                    YZToast.show(this@ShowInterstitialActivity, "Interstitial open...")
                }

                override fun onInterstitialAdLoaded() {
                    Log.d(TAG, "加载插屏广告成功")
                    YZToast.show(this@ShowInterstitialActivity, "Interstitial load success...")
                    mIntersitial?.showAd()
                }

                override fun onInterstitialAdClicked() {
                    Log.d(TAG, "点击插屏广告")
                }
            },
            "3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-2",
            AdSize(adViewWidth, adViewHeight))
        mIntersitial!!.loadAd()
    }

}