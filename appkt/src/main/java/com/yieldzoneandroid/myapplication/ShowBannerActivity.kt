package com.yieldzoneandroid.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

import com.yieldzone.ads.YieldzoneAdBannerAd
import com.yieldzone.baselibrary.AdSize
import com.yieldzone.baselibrary.YieldzoneLoadAdError
import com.yieldzone.baselibrary.listeners.BannerAdListener
import com.yieldzoneandroid.myapplication.R
import kotlinx.android.synthetic.main.activity_show_banner.*

class ShowBannerActivity : AppCompatActivity() {

    var banner1 :YieldzoneAdBannerAd? = null

    companion object {
        fun start(context: Context) {
            val intent: Intent = Intent(context, ShowBannerActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_banner)
        btn1.setOnClickListener {
            banner1 = YieldzoneAdBannerAd(
                this@ShowBannerActivity,
                object : BannerAdListener {
                    override fun onBannerAdClosed() {
                        Log.d("ShowBannerActivity", "关闭广告")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner close..."
                        )
                    }

                    override fun onBannerAdExpose() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告Expose"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner expose..."
                        )
                    }

                    override fun onAdFailedToLoad(errorCode: Int) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onAdFailedToLoad(error: YieldzoneLoadAdError) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onBannerAdOpened() {
                        Log.d(
                            "ShowBannerActivity",
                            "展示广告opoen"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner opened..."
                        )
                    }

                    override fun onBannerAdLoaded() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告加载成功"
                        )
                        banner1?.showBanner(adContainer)
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner load success..."
                        )
                    }

                    override fun onBannerAdClicked() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告被点击"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner click..."
                        )
                    }
                },
                "3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1",
                AdSize.BANNER_320_50
            ) //3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
            banner1?.loadAd();
        }
        btn2.setOnClickListener {
            banner1 = YieldzoneAdBannerAd(
                this@ShowBannerActivity,
                object : BannerAdListener {
                    override fun onBannerAdClosed() {
                        Log.d("ShowBannerActivity", "关闭广告")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner close..."
                        )
                    }

                    override fun onBannerAdExpose() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告Expose"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner expose..."
                        )
                    }

                    override fun onAdFailedToLoad(errorCode: Int) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onAdFailedToLoad(error: YieldzoneLoadAdError) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onBannerAdOpened() {
                        Log.d(
                            "ShowBannerActivity",
                            "展示广告opoen"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner opened..."
                        )
                    }

                    override fun onBannerAdLoaded() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告加载成功"
                        )
                        banner1?.showBanner(adContainer)
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner load success..."
                        )
                    }

                    override fun onBannerAdClicked() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告被点击"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner click..."
                        )
                    }
                },
                "3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1",
                AdSize.BANNER_320_100
            ) //3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
        }
        btn3.setOnClickListener {
            banner1 = YieldzoneAdBannerAd(
                this@ShowBannerActivity,
                object : BannerAdListener {
                    override fun onBannerAdClosed() {
                        Log.d("ShowBannerActivity", "关闭广告")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner close..."
                        )
                    }

                    override fun onBannerAdExpose() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告Expose"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner expose..."
                        )
                    }

                    override fun onAdFailedToLoad(errorCode: Int) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onAdFailedToLoad(error: YieldzoneLoadAdError) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onBannerAdOpened() {
                        Log.d(
                            "ShowBannerActivity",
                            "展示广告opoen"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner opened..."
                        )
                    }

                    override fun onBannerAdLoaded() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告加载成功"
                        )
                        banner1?.showBanner(adContainer)
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner load success..."
                        )
                    }

                    override fun onBannerAdClicked() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告被点击"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner click..."
                        )
                    }
                },
                "3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1",
                AdSize.BANNER_320_250
            ) //3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
        }
        btn4.setOnClickListener {
            banner1 = YieldzoneAdBannerAd(
                this@ShowBannerActivity,
                object : BannerAdListener {
                    override fun onBannerAdClosed() {
                        Log.d("ShowBannerActivity", "关闭广告")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner close..."
                        )
                    }

                    override fun onBannerAdExpose() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告Expose"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner expose..."
                        )
                    }

                    override fun onAdFailedToLoad(errorCode: Int) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onAdFailedToLoad(error: YieldzoneLoadAdError) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onBannerAdOpened() {
                        Log.d(
                            "ShowBannerActivity",
                            "展示广告opoen"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner opened..."
                        )
                    }

                    override fun onBannerAdLoaded() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告加载成功"
                        )
                        banner1?.showBanner(adContainer)
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner load success..."
                        )
                    }

                    override fun onBannerAdClicked() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告被点击"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner click..."
                        )
                    }
                },
                "3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1",
                AdSize.BANNER_468_60
            ) //3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
        }
        btn5.setOnClickListener {
            banner1 = YieldzoneAdBannerAd(
                this@ShowBannerActivity,
                object : BannerAdListener {
                    override fun onBannerAdClosed() {
                        Log.d("ShowBannerActivity", "关闭广告")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner close..."
                        )
                    }

                    override fun onBannerAdExpose() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告Expose"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner expose..."
                        )
                    }

                    override fun onAdFailedToLoad(errorCode: Int) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onAdFailedToLoad(error: YieldzoneLoadAdError) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onBannerAdOpened() {
                        Log.d(
                            "ShowBannerActivity",
                            "展示广告opoen"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner opened..."
                        )
                    }

                    override fun onBannerAdLoaded() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告加载成功"
                        )

                        banner1?.showBanner(adContainer)
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner load success..."
                        )
                    }

                    override fun onBannerAdClicked() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告被点击"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner click..."
                        )
                    }
                },
                "3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1",
                AdSize.BANNER_728_90
            ) //3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
        }
        btn6.setOnClickListener {
            banner1 = YieldzoneAdBannerAd(
                this@ShowBannerActivity,
                object : BannerAdListener {
                    override fun onBannerAdClosed() {
                        Log.d("ShowBannerActivity", "关闭广告")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner close..."
                        )
                    }

                    override fun onBannerAdExpose() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告Expose"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner expose..."
                        )
                    }

                    override fun onAdFailedToLoad(errorCode: Int) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onAdFailedToLoad(error: YieldzoneLoadAdError) {
                        Log.d("ShowBannerActivity", "加载失败")
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner failed..."
                        )
                    }

                    override fun onBannerAdOpened() {
                        Log.d(
                            "ShowBannerActivity",
                            "展示广告opoen"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner opened..."
                        )
                    }

                    override fun onBannerAdLoaded() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告加载成功"
                        )

                        banner1?.showBanner(adContainer)
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner load success..."
                        )
                    }

                    override fun onBannerAdClicked() {
                        Log.d(
                            "ShowBannerActivity",
                            "广告被点击"
                        )
                        YZToast.show(
                            this@ShowBannerActivity,
                            "banner click..."
                        )
                    }
                },
                "3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1",
                AdSize.BANNER_320_90
            ) //3DBFEE43-501F-F6DE-3F56-01AE2F44BF40-1
        }
    }
}