package com.yangkl.quick.library.base

import com.tencent.mmkv.MMKV

open class QuickCache(configName: String) {
    private val config: MMKV = MMKV.mmkvWithID(configName)

    fun getBoolean(key: String): Boolean {
        return config.getBoolean(key, false)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return config.getBoolean(key, defaultValue)
    }

    fun setBoolean(key: String, value: Boolean) {
        config.putBoolean(key, value)
    }

    fun getString(key: String): String? {
        return config.getString(key, null)
    }

    fun getString(key: String, defaultValue: String?): String? {
        return config.getString(key, defaultValue)
    }

    fun setString(key: String, value: String?) {
        config.putString(key, value)
    }

    fun getInt(key: String): Int {
        return config.getInt(key, 0)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return config.getInt(key, defaultValue)
    }

    fun setInt(key: String, value: Int) {
        config.putInt(key, value)
    }

    fun getLong(key: String): Long {
        return config.getLong(key, 0)
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return config.getLong(key, defaultValue)
    }

    fun setLong(key: String, value: Long) {
        config.putLong(key, value)
    }

    fun getFloat(key: String): Float {
        return config.getFloat(key, 0f)
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        return config.getFloat(key, defaultValue)
    }

    protected open fun setFloat(key: String, value: Float) {
        config.putFloat(key, value).apply()
    }

    protected open fun removeValue(key: String) {
        config.remove(key)
    }
}