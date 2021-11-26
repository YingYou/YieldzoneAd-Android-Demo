package com.yieldzoneandroid.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yieldzone.ads.YieldzoneAdRewardVideoAd
import com.yieldzone.baselibrary.YieldzoneLoadAdError
import com.yieldzone.baselibrary.listeners.RewardedVideoListener
import com.yieldzoneandroid.myapplication.R
import kotlinx.android.synthetic.main.ad_show_reward.*

/***
Created by weiyang

on 8/10/21
Copyright (c) 2021 Yieldzone. All rights reserved.
 ***/
class ShowRewardActivity : AppCompatActivity(){

    private val TAG: String =
        ShowRewardActivity::class.java.getSimpleName()

    private var mReward:YieldzoneAdRewardVideoAd ? = null

    companion object {
    fun start(context: Context) {
        val intent =
            Intent(context, ShowRewardActivity::class.java)
        context.startActivity(intent)
    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ad_show_reward)

        show_reward.setOnClickListener { showLoadReward() }
    }

    private fun showLoadReward() {
        mReward = YieldzoneAdRewardVideoAd(this@ShowRewardActivity,object : RewardedVideoListener {
            override fun onRewardedVideoAdClosed() {
                Log.d(TAG, "reward onAdClosed()")
            }

            override fun onRewardedVideoAdExpose() {
                Log.d(TAG, "reward onRewardedVideoAdExpose()")
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                Log.d(TAG, "reward onAdFailedToLoad()")
            }

            override fun onAdFailedToLoad(error: YieldzoneLoadAdError) {
                Log.d(TAG, "reward onAdFailedToLoad()")
            }

            override fun onRewardedVideoAdOpened() {
                Log.d(TAG, "reward onAdOpened()")
            }

            override fun onRewardedVideoAdLoaded() {
                Log.d(TAG, "reward onAdLoaded()")
                mReward?.showAd()
            }

            override fun onRewardedVideoAdClicked() {
                Log.d(TAG, "reward onAdClicked()")
            }

            override fun onRewardedVideoAdRewarded() {}
        }, "2E259AAC-7518-4EA1-949D-4D8A0F3B49EF")
        mReward!!.loadAd()
    }
}