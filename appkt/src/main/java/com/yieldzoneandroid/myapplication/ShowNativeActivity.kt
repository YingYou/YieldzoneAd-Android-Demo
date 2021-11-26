package com.yieldzoneandroid.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.yieldzone.ads.YieldzoneNativeExpressAd
import com.yieldzone.baselibrary.AdSize
import com.yieldzone.baselibrary.YieldzoneLoadAdError
import com.yieldzone.baselibrary.YieldzoneNativeCardType
import com.yieldzone.baselibrary.listeners.NativeAdListener
import com.yieldzoneandroid.myapplication.R
import kotlinx.android.synthetic.main.activity_show_native.*

class ShowNativeActivity : AppCompatActivity() {
    private val TAG: String =
        ShowNativeActivity::class.java.getSimpleName()

    var mNative:YieldzoneNativeExpressAd ?= null

    companion object {
        fun start(context: Context) {
            val intent: Intent = Intent(context, ShowNativeActivity::class.java)
            context.startActivity(intent)
        }
    }

    fun dip2px(dipValue: Float): Int {
        val scale = this.resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_native)

        show_native.setOnClickListener {
            nativeContainer.removeAllViews()
            showLoadNative()
        }

    }

    fun showLoadNative() {

        val padding = dip2px(10f)
        val containerHeight = dip2px(340f)
        val adViewWidth = resources.displayMetrics.widthPixels - 2 * padding
        val adViewHeight = adViewWidth

        val linearParams =
            nativeContainer.getLayoutParams() as LinearLayout.LayoutParams
        linearParams.height = adViewHeight;///4
        linearParams.width = adViewWidth
        nativeContainer.setLayoutParams(linearParams)


        mNative = YieldzoneNativeExpressAd(this@ShowNativeActivity,object : NativeAdListener{

            override fun onNativeAdClicked() {

            }

            override fun onAdFailedToLoad(p0: Int) {

            }

            override fun onAdFailedToLoad(p0: YieldzoneLoadAdError?) {
                Log.d(TAG, "广告加载失败")
            }

            override fun onNativeAdClosed() {

            }

            override fun onNativeAdOpened() {

            }

            override fun onNativeAdExpose() {
                //
            }

            override fun onNativeAdLoaded() {
                mNative?.showAd(nativeContainer)

            }
        }, "3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-4",
            AdSize(adViewWidth, adViewHeight), YieldzoneNativeCardType.YieldzoneNativeExpressTopMediaBottomText
        )//3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-4
        mNative!!.loadAd()
    }


}