package com.baidu.common

import android.util.Log

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/6/9 7:54 下午
 */
private const val TAG = "LogUtil"

object LogUtil {

    fun i(str: String) {
        Log.i(TAG, "i: $str")
    }

    fun e(str: String) {
        Log.e(TAG, "e: $str")
    }

}


fun Any?.logW() {
    if (this != Unit) {
        println("unit")
    }
    Log.w(TAG, "logW: ${this?.toString()}")

}