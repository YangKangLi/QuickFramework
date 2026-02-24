package com.yangkl.quick.library.dialog

import android.view.View
import android.widget.TextView
import com.yangkl.quick.library.R

class QuickWaitDialog(private val content: String? = null) : QuickBaseDialog(R.layout.dialog_default_wait_layout, null) {
    override fun initView(view: View?) {
        view?.apply {
            findViewById<TextView>(R.id.tv_dialog_content).text = content
        }
    }
}