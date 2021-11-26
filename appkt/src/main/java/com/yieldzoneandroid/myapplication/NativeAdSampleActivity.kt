package com.yieldzoneandroid.myapplication
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.ads.*
import com.facebook.ads.NativeAdBase.NativeComponentTag
import java.util.*

/***
Created by weiyang
on 7/15/21
Copyright (c) 2021 yieldzone. All rights reserved.
 ***/
class NativeAdSampleActivity : AppCompatActivity() {

    protected val TAG = NativeAdSampleActivity::class.java.simpleName

    private var nativeAdStatus: TextView? = null
    private var adChoicesContainer: LinearLayout? = null

    private var nativeAdLayout: NativeAdLayout? = null
    private var mlinear: LinearLayout? = null
    private var nativeAd: NativeAd? = null
    private var adOptionsView: AdOptionsView? = null
    private var nativeAdMedia: MediaView? = null

    private var originalScreenOrientationFlag = 0

    companion object {
        fun start(context: Context) {
            val intent: Intent = Intent(context, NativeAdSampleActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  block auto screen orientation for NativeAdSampleFragment.
        setContentView(R.layout.fragment_native_ad_sample)
//        val view: View =
//            inflater.inflate(R.layout.fragment_native_ad_sample, container, false)
        val linearLayout = findViewById<LinearLayout>(R.id.native_ad_container)
        mlinear = layoutInflater.inflate(R.layout.native_ad_unit, null, false) as LinearLayout?
        nativeAdLayout = NativeAdLayout(this)
        val params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        linearLayout.removeAllViews()
        linearLayout.addView(nativeAdLayout, params)
        nativeAdStatus = this.findViewById(R.id.native_ad_status)
        adChoicesContainer = this.findViewById(R.id.ad_choices_container)
        val showNativeAdButton =
            this.findViewById<Button>(R.id.load_native_ad_button)
        showNativeAdButton.setOnClickListener {
            if (nativeAdStatus != null) {
                nativeAdStatus!!.text = "loading"
            }

            // Create a native ad request with a unique placement ID (generate your own on the
            // Facebook app settings). Use different ID for each ad placement in your app.
            nativeAd = NativeAd(this, "YOUR_PLACEMENT_ID")

            // When testing on a device, add its hashed ID to force test ads.
            // The hash ID is printed to log cat when running on a device and loading an ad.
            // AdSettings.addTestDevice("THE HASHED ID AS PRINTED TO LOG CAT");

            // Initiate a request to load an ad.

            // When testing on a device, add its hashed ID to force test ads.
            // The hash ID is printed to log cat when running on a device and loading an ad.
            // AdSettings.addTestDevice("THE HASHED ID AS PRINTED TO LOG CAT");

            // Initiate a request to load an ad.
            nativeAd!!.loadAd(
                nativeAd!!.buildLoadAdConfig()
                    .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                    .withAdListener(object : NativeAdListener {
                        override fun onMediaDownloaded(ad: Ad) {}
                        override fun onError(ad: Ad, adError: AdError) {}
                        override fun onAdLoaded(ad: Ad) {
                            if (nativeAd == null || nativeAd !== ad) {
                                // Race condition, load() called again before last ad was displayed
                                return
                            }

                            if (nativeAdLayout == null) {
                                return
                            }
                            nativeAdLayout!!.addView(mlinear)

                            // Unregister last ad

                            // Unregister last ad
                            nativeAd!!.unregisterView()

                            if (nativeAdStatus != null) {
                                nativeAdStatus!!.text = ""
                            }

                            if (!nativeAd!!.isAdLoaded || nativeAd!!.isAdInvalidated) {
                                if (nativeAdStatus != null) {
                                    nativeAdStatus!!.text = "Ad is not loaded or invalidated."
                                }
                                return
                            }

                            if (adChoicesContainer != null) {
                                adOptionsView =
                                    AdOptionsView(this@NativeAdSampleActivity, nativeAd, nativeAdLayout)
                                adChoicesContainer!!.removeAllViews()
                                adChoicesContainer!!.addView(adOptionsView, 0)
                            }

                            inflateAd(nativeAd!!, mlinear)

                            // Registering a touch listener to log which ad component receives the touch event.
                            // We always return false from onTouch so that we don't swallow the touch event (which
                            // would prevent click events from reaching the NativeAd control).
                            // The touch listener could be used to do animations.

                            // Registering a touch listener to log which ad component receives the touch event.
                            // We always return false from onTouch so that we don't swallow the touch event (which
                            // would prevent click events from reaching the NativeAd control).
                            // The touch listener could be used to do animations.
                            nativeAd!!.setOnTouchListener { view, event ->
                                if (event.action == MotionEvent.ACTION_DOWN) {
                                    val i = view.id
                                    if (i == R.id.native_ad_call_to_action) {
////                                        Log.d(
//                                            NativeAdSampleFragment.TAG,
//                                            "Call to action button clicked"
//                                        )
                                    } else if (i == R.id.native_ad_media) {
//                                        Log.d(
//                                            NativeAdSampleFragment.TAG,
//                                            "Main image clicked"
//                                        )
                                    } else {
//                                        Log.d(
//                                            NativeAdSampleFragment.TAG,
//                                            "Other ad component clicked"
//                                        )
                                    }
                                }
                                false
                            }
                        }
                        override fun onAdClicked(ad: Ad) {}
                        override fun onLoggingImpression(ad: Ad) {}
                    }).build()
            )
        }
//        return view
    }

//    override fun onDestroyView() {
//        if (activity != null) {
//            activity!!.requestedOrientation = originalScreenOrientationFlag
//        }
//        adChoicesContainer = null
//        nativeAdLayout = null
//        adOptionsView = null
//        nativeAdStatus = null
//        super.onDestroyView()
//    }

    fun onError(ad: Ad?, error: AdError) {
        if (nativeAdStatus != null) {
            nativeAdStatus!!.text = "Ad failed to load: " + error.errorMessage
        }
    }

    fun onAdClicked(ad: Ad?) {
        Toast.makeText(this, "Ad Clicked", Toast.LENGTH_SHORT).show()
    }

    fun onLoggingImpression(ad: Ad?) {
        Toast.makeText(this, "Native Impression", Toast.LENGTH_SHORT).show()
    }

    fun onMediaDownloaded(ad: Ad) {
        if (nativeAd === ad) {
            Log.d(TAG, "onMediaDownloaded")
        }
    }

    fun onAdLoaded(ad: Ad) {
        if (nativeAd == null || nativeAd !== ad) {
            // Race condition, load() called again before last ad was displayed
            return
        }
        if (nativeAdLayout == null) {
            return
        }
        nativeAdLayout!!.addView(mlinear)

        // Unregister last ad
        nativeAd!!.unregisterView()
        if (nativeAdStatus != null) {
            nativeAdStatus!!.text = ""
        }
        if (!nativeAd!!.isAdLoaded || nativeAd!!.isAdInvalidated) {
            if (nativeAdStatus != null) {
                nativeAdStatus!!.text = "Ad is not loaded or invalidated."
            }
            return
        }
        if (adChoicesContainer != null) {
            adOptionsView = AdOptionsView(this, nativeAd, nativeAdLayout)
            adChoicesContainer!!.removeAllViews()
            adChoicesContainer!!.addView(adOptionsView, 0)
        }
        inflateAd(nativeAd!!, mlinear)

        // Registering a touch listener to log which ad component receives the touch event.
        // We always return false from onTouch so that we don't swallow the touch event (which
        // would prevent click events from reaching the NativeAd control).
        // The touch listener could be used to do animations.
        nativeAd!!.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val i = view.id
                if (i == R.id.native_ad_call_to_action) {
                    Log.d(TAG, "Call to action button clicked")
                } else if (i == R.id.native_ad_media) {
                    Log.d(TAG, "Main image clicked")
                } else {
                    Log.d(TAG, "Other ad component clicked")
                }
            }
            false
        }
    }

    private fun inflateAd(
        nativeAd: NativeAd,
        adView: View?
    ) {
        Log.d(TAG, "Aspect ratio of ad: " + nativeAd.aspectRatio)

        // Create native UI using the ad metadata.
        val nativeAdIcon: MediaView = adView!!.findViewById(R.id.native_ad_icon)
        val nativeAdTitle = adView.findViewById<TextView>(R.id.native_ad_title)
        val nativeAdBody = adView.findViewById<TextView>(R.id.native_ad_body)
        val sponsoredLabel = adView.findViewById<TextView>(R.id.native_ad_sponsored_label)
        val nativeAdSocialContext =
            adView.findViewById<TextView>(R.id.native_ad_social_context)
        val nativeAdCallToAction =
            adView.findViewById<Button>(R.id.native_ad_call_to_action)
        nativeAdMedia = adView.findViewById(R.id.native_ad_media)
//        nativeAdMedia.setListener(getMediaViewListener())

        // Setting the Text
        nativeAdSocialContext.text = nativeAd.adSocialContext
        nativeAdCallToAction.text = nativeAd.adCallToAction
        nativeAdCallToAction.visibility =
            if (nativeAd.hasCallToAction()) View.VISIBLE else View.INVISIBLE
        nativeAdTitle.text = nativeAd.advertiserName
        nativeAdBody.text = nativeAd.adBodyText
        sponsoredLabel.setText(R.string.sponsored)

        // You can use the following to specify the clickable areas.
        val clickableViews: MutableList<View?> =
            ArrayList()
        clickableViews.add(nativeAdIcon)
        clickableViews.add(nativeAdMedia)
        clickableViews.add(nativeAdCallToAction)
        nativeAd.registerViewForInteraction(
            nativeAdLayout, nativeAdMedia, nativeAdIcon, clickableViews
        )

        // Optional: tag views
        NativeComponentTag.tagView(nativeAdIcon, NativeComponentTag.AD_ICON)
        NativeComponentTag.tagView(nativeAdTitle, NativeComponentTag.AD_TITLE)
        NativeComponentTag.tagView(nativeAdBody, NativeComponentTag.AD_BODY)
        NativeComponentTag.tagView(nativeAdSocialContext, NativeComponentTag.AD_SOCIAL_CONTEXT)
        NativeComponentTag.tagView(nativeAdCallToAction, NativeComponentTag.AD_CALL_TO_ACTION)
    }

    override fun onDestroy() {
        if (nativeAdMedia != null) {
            nativeAdMedia!!.destroy()
        }
        if (nativeAd != null) {
            nativeAd!!.unregisterView()
            nativeAd!!.destroy()
        }
        super.onDestroy()
    }

    private fun getMediaViewListener(): MediaViewListener? {
        return object : MediaViewListener {
            override fun onVolumeChange(
                mediaView: MediaView,
                volume: Float
            ) {
                Log.i(TAG, "MediaViewEvent: Volume $volume")
            }

            override fun onPause(mediaView: MediaView) {
                Log.i(TAG, "MediaViewEvent: Paused")
            }

            override fun onPlay(mediaView: MediaView) {
                Log.i(TAG, "MediaViewEvent: Play")
            }

            override fun onFullscreenBackground(mediaView: MediaView) {
                Log.i(TAG, "MediaViewEvent: FullscreenBackground")
            }

            override fun onFullscreenForeground(mediaView: MediaView) {
                Log.i(TAG, "MediaViewEvent: FullscreenForeground")
            }

            override fun onExitFullscreen(mediaView: MediaView) {
                Log.i(TAG, "MediaViewEvent: ExitFullscreen")
            }

            override fun onEnterFullscreen(mediaView: MediaView) {
                Log.i(TAG, "MediaViewEvent: EnterFullscreen")
            }

            override fun onComplete(mediaView: MediaView) {
                Log.i(TAG, "MediaViewEvent: Completed")
            }
        }
    }
}