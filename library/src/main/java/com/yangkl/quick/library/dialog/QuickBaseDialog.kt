package com.yangkl.quick.library.dialog

import android.os.Bundle
import android.view.View
import androidx.core.graphics.toColorInt
import com.kongzue.dialogx.dialogs.CustomDialog
import com.kongzue.dialogx.interfaces.OnBindView

abstract class QuickBaseDialog(layoutResId: Int, protected val clickListener: OnClickListener? = null) {

    interface OnClickListener {
        fun onClick(data: Bundle? = null)
    }

    private val customDialog = CustomDialog.build(object : OnBindView<CustomDialog>(layoutResId) {
        override fun onBind(dialog: CustomDialog?, view: View?) {
            initView(view)
        }
    })

    abstract fun initView(view: View?)

    fun showCenter(): QuickBaseDialog {
        customDialog.setEnterAnimResId(0)
            .setMaskColor("#80000000".toColorInt())
            .setAlign(CustomDialog.ALIGN.CENTER)
            .setCancelable(false).show()
        return this
    }


    fun showBottom(): QuickBaseDialog {
        customDialog.setEnterAnimResId(0)
            .setMaskColor("#80000000".toColorInt())
            .setAlign(CustomDialog.ALIGN.BOTTOM)
            .setCancelable(false).show()
        return this
    }

    fun dismiss() {
        customDialog.dismiss()
    }
}