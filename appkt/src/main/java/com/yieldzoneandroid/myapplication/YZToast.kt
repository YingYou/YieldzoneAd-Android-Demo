package com.yieldzoneandroid.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast

/***
Created by weiyang

on 8/10/21
Copyright (c) 2021 Yieldzone. All rights reserved.
 ***/
class YZToast {
    companion object {
    private var sToast: Toast? = null

    fun show(context: Context?, msg: String) {
        show(context, msg, Toast.LENGTH_SHORT)
    }


    fun show(
        context: Context?,
        msg: String,
        duration: Int
    ) {
        val toast = getToast(context)
        if (toast != null) {
            toast.duration = duration
            toast.setText(msg)
            toast.show()
        } else {
            Log.i("TToast", "toast msg: $msg")
        }
    }


    @SuppressLint("ShowToast")
    private fun getToast(context: Context?): Toast? {
        if (context == null) {
            return sToast
        }
        //        if (sToast == null) {
//            synchronized (TToast.class) {
//                if (sToast == null) {
        sToast = Toast.makeText(context.applicationContext, "", Toast.LENGTH_SHORT)
        //                }
//            }
//        }
        return sToast
    }

    fun reset() {
        sToast = null
    }
    }
}