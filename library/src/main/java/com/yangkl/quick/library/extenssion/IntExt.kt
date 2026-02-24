package com.yangkl.quick.library.extenssion

import com.blankj.utilcode.util.Utils

val Int.dp: Float
    get() = Utils.getApp().resources.displayMetrics.density * this + 0.5f

val Int.dpInt: Int
    get() = this.dp.toInt()