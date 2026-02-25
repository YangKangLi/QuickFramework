package com.yangkl.quick.library.dialog

import android.view.View
import android.widget.TextView
import com.yangkl.quick.library.R

class QuickAlertDialog(private val title: String, private val content: String? = null, clickListener: OnClickListener? = null) : QuickBaseDialog(R.layout.dialog_default_alert_layout, clickListener) {

    override fun initView(view: View?) {
        view?.apply {
            findViewById<TextView>(R.id.tv_dialog_title).text = title
            findViewById<TextView>(R.id.tv_dialog_content).text = content

            findViewById<View>(R.id.btn_dialog_positive)?.setOnClickListener {
                clickListener?.onClick(this@QuickAlertDialog, true)
            }
        }
    }
}