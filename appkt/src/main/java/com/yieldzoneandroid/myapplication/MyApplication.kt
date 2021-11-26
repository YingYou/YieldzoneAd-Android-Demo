package com.yieldzoneandroid.myapplication

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.yieldzone.ads.YieldzoneAdSplashAd
import com.yieldzone.baselibrary.YieldzoneLoadAdError
import com.yieldzone.baselibrary.listeners.SplashAdListener
import com.yieldzone.library.YieldzoneAdApi

class MyApplication : MultiDexApplication() {
    val TAG: String = "MyApplication"
    override fun onCreate() {
        super.onCreate()
//        YieldzoneAdApi.setDebug(true)
        YieldzoneAdApi.init(
            this,
            "3DBFEE43-501F-F6DE-3F56-01AE2F44BF40"
        ) {

        }
    }
}