package com.yieldzoneandroid.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.yieldzone.ads.YieldzoneAdSplashAd
import com.yieldzone.baselibrary.YieldzoneLoadAdError
import com.yieldzone.baselibrary.listeners.SplashAdListener
import com.yieldzoneandroid.myapplication.R

class SplashAdActivity: AppCompatActivity(){
    val TAG: String = "SplashAdActivity"

    var mSplashContainer: ViewGroup? = null

    var mSplash: YieldzoneAdSplashAd? = null

    companion object {
        fun start(context: Context) {
            val intent: Intent = Intent(context, SplashAdActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ad_splash)
        mSplashContainer = findViewById(R.id.splash_container)

        mSplash = YieldzoneAdSplashAd(this@SplashAdActivity,object :
            SplashAdListener {
            override fun onSplashAdDismissed() {
                Log.d(TAG, "onAdClosed()")
                finish()
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                Log.d(TAG, "onAdFailedToLoad()")
            }

            override fun onAdFailedToLoad(error: YieldzoneLoadAdError) {
                Log.d(TAG, "onAdFailedToLoad()")
            }

            override fun onSplashAdShowed() {
              //  TODO("Not yet implemented")
                Log.d(TAG, "onAdOpened()")
            }

            override fun onSplashAdLoad() {
                Log.d(TAG, "onAdLoaded()")
                mSplash?.showAd()
            }

            override fun onSplashAdClicked() {
                Log.d(TAG, "onAdClicked()")
            }

        }, "3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-3")//3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-3
        mSplash!!.loadAd()
    }

}