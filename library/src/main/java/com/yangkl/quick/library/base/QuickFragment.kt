package com.yangkl.quick.library.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.ToastUtils
import com.yangkl.quick.library.extenssion.showCenter

open class QuickFragment : Fragment() {

    /**
     * 创建ViewModel对象
     */
    protected fun <T : QuickViewModel> createViewModel(clazz: Class<T>): T {
        return ViewModelProvider(this, getDefaultFactory())[clazz]
    }

    /**
     * 获得默认的ViewModelProvider.Factory
     *
     * @return
     */
    private fun getDefaultFactory(): ViewModelProvider.Factory {
        return ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
    }

    /**
     * 显示 Toast 消息
     */
    fun showCenterToast(text: String) {
        ToastUtils.make().showCenter(text)
    }
}