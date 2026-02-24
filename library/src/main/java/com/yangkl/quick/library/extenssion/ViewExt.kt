package com.yangkl.quick.library.extenssion

import android.view.View
import com.blankj.utilcode.util.BarUtils

/**
 * 调整TitleBar的尺寸
 */
fun View.resizeTitleBar() {
    val statusBarHeight = BarUtils.getStatusBarHeight()
    setPadding(paddingLeft, paddingTop + statusBarHeight, paddingRight, paddingBottom)
    layoutParams.height += statusBarHeight
}