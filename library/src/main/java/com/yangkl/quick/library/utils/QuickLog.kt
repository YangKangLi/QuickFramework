package com.yangkl.quick.library.utils

import android.text.TextUtils
import android.util.Log
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.Utils
import java.io.File

object QuickLog {

    /**
     * 是否打印日志
     */
    var loggable: Boolean = false

    /**
     * 打印调试级别日志
     */
    fun d(log: String, tag: String = "QuickApp", write2File: Boolean = true) {
        if (loggable) {
            LogUtils.dTag(tag, log)
            if (write2File) {
                write2File(log)
            }
        }
    }

    /**
     * 打印信息级别日志
     */
    fun i(log: String, tag: String = "QuickApp", write2File: Boolean = true) {
        if (loggable) {
            LogUtils.iTag(tag, log)
            if (write2File) {
                write2File(log)
            }
        }
    }

    /**
     * 打印错误级别日志
     */
    fun e(log: String, tag: String = "QuickApp", write2File: Boolean = true) {
        if (loggable) {
            LogUtils.eTag(tag, log)
            if (write2File) {
                write2File(log)
            }
        }
    }

    /**
     * 将日志写入文件
     */
    private fun write2File(log: String) {
        val logFolder = File(Utils.getApp().getExternalFilesDir(""), "Logs")
        if (!logFolder.exists()) {
            logFolder.mkdirs()
        }
        if ("QuickLog" != LogUtils.getConfig().filePrefix) {
            LogUtils.getConfig().setDir(logFolder)
            LogUtils.getConfig().setFilePrefix("QuickLog")
            LogUtils.getConfig().setFileExtension("log")
            LogUtils.getConfig().setSaveDays(7)
        }
        LogUtils.file(log)
    }
}