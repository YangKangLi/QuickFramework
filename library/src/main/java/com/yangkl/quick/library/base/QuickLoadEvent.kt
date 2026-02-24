package com.yangkl.quick.library.base

sealed class QuickLoadEvent<T>(
    val data: T? = null,
    val msg: String? = null
) {
    class Start<T>(msg: String) : QuickLoadEvent<T>(msg = msg)
    class Success<T>(data: T?, msg: String? = null) : QuickLoadEvent<T>(data = data, msg = msg)
    class Error<T>(error: String) : QuickLoadEvent<T>(msg = error)

    override fun toString(): String {
        return when (this) {
            is Start<T> -> "Loading[msg=$msg]"
            is Success<*> -> "Success[data=$data, msg=$msg]"
            is Error -> "Error[exception=$msg]"
        }
    }
}