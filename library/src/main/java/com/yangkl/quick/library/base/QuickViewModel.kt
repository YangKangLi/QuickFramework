package com.yangkl.quick.library.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.DefaultLifecycleObserver

open class QuickViewModel(app: Application) : AndroidViewModel(app), DefaultLifecycleObserver {


}