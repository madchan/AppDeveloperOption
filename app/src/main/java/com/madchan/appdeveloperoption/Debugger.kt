package com.madchan.appdeveloperoption

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

/**
 * 调试器
 */
object Debugger {

    /** 快速点击次数 */
    private var clickCount = 0
    /** 最后一次快速点击时间戳  */
    private var lastClickTime: Long = 0

    /**
     * 快速点击监听
     */
    fun onQuickClick(activity: AppCompatActivity) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime < 500) {
            clickCount++
            if (clickCount > 10) {
                clickCount = 0
                DebugLoginDialogFragment.newInstance().show(activity.supportFragmentManager, "")
            }
        } else {
            clickCount = 0
        }
        lastClickTime = System.currentTimeMillis()
    }
}