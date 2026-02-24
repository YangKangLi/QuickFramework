package com.yangkl.quick.library.extenssion

import android.graphics.Color
import android.view.Gravity
import com.blankj.utilcode.util.ToastUtils

fun ToastUtils.showCenter(text: String) {
    setGravity(Gravity.CENTER, 0, 0)
        .setBgColor(Color.BLACK)
        .setTextColor(Color.WHITE)
        .show(text)
}

fun ToastUtils.showBottom(text: String) {
    setGravity(Gravity.BOTTOM, 0, 0)
        .setBgColor(Color.BLACK)
        .setTextColor(Color.WHITE)
        .show(text)
}