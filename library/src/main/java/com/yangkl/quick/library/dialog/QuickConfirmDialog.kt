package com.yangkl.quick.library.dialog

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.yangkl.quick.library.R

class QuickConfirmDialog(private val title: String, private val content: String? = null, clickListener: OnClickListener? = null) : QuickBaseDialog(R.layout.dialog_default_confirm_layout, clickListener) {

    companion object {
        const val KEY_IS_POSITIVE = "key_is_positive"
    }

    override fun initView(view: View?) {
        view?.apply {
            findViewById<TextView>(R.id.tv_dialog_title).text = title
            findViewById<TextView>(R.id.tv_dialog_content).setText(content)

            findViewById<View>(R.id.btn_dialog_negative)?.setOnClickListener {
                dismiss()
                val data = Bundle()
                data.putBoolean(KEY_IS_POSITIVE, false)
                clickListener?.onClick(data)
            }

            findViewById<View>(R.id.btn_dialog_positive)?.setOnClickListener {
                dismiss()
                val data = Bundle()
                data.putBoolean(KEY_IS_POSITIVE, true)
                clickListener?.onClick(data)
            }
        }
    }
}