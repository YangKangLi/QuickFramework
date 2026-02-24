package com.yangkl.quick.library

import android.app.Application
import com.kongzue.dialogx.DialogX
import com.tencent.mmkv.MMKV

open class QuickApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
        DialogX.init(this)
    }
}