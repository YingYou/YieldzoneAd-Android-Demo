package com.yieldzoneandroid.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yieldzone.baselibrary.YieldzoneLoadAdError
import com.yieldzone.baselibrary.listeners.VideoAdListener
import com.yieldzone.library.YieldzoneAdApi
import com.yieldzoneandroid.myapplication.R

/***
Created by weiyang

on 8/10/21
Copyright (c) 2021 Yieldzone. All rights reserved.
 ***/
class ShowDrawVideoActivity  : AppCompatActivity(){

    private val TAG: String =
        ShowDrawVideoActivity::class.java.getSimpleName()

    private var show_drawvideo: Button? = null

    companion object {
    fun start(context: Context) {
        val intent =
            Intent(context, ShowDrawVideoActivity::class.java)
        context.startActivity(intent)
    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ad_show_drawvideo)

        show_drawvideo?.setOnClickListener(View.OnClickListener { showLoadDrawVideo() })
    }

    private fun showLoadDrawVideo() {
        YieldzoneAdApi.loadVideo(object : VideoAdListener {
            override fun onAdClosed() {}
            override fun onUserEarnedReward() {}
            override fun onAdFailedToLoad(errorCode: Int) {}
            override fun onAdFailedToLoad(error: YieldzoneLoadAdError) {}
            override fun onAdOpened() {}
            override fun onAdLoaded() {
                YieldzoneAdApi.showVideo()
            }

            override fun onAdClicked() {}
        }," 2E259AAC-7518-4EA1-949D-4D8A0F3B49EF")
    }
}