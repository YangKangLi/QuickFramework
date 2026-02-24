package com.yangkl.quick.library.base

import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.ToastUtils
import com.yangkl.quick.library.dialog.QuickWaitDialog
import com.yangkl.quick.library.extenssion.showCenter

open class QuickActivity : AppCompatActivity() {

    private var waitDialog: QuickWaitDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * 设置沉浸式状态栏
     */
    protected open fun setActivityBar() {
        BarUtils.setStatusBarLightMode(this, true)
        BarUtils.setNavBarVisibility(this, false)
        BarUtils.setNavBarColor(this, Color.BLACK)
        BarUtils.setStatusBarColor(this, Color.BLACK)
        BarUtils.setStatusBarVisibility(this, true)
    }


    /**
     * 创建ViewModel对象
     */
    protected fun <T : QuickViewModel> createViewModel(clazz: Class<T>): T {
        return ViewModelProvider(this, getDefaultFactory())[clazz]
    }

    /**
     * 获得默认的ViewModelProvider.Factory
     */
    private fun getDefaultFactory(): ViewModelProvider.Factory {
        return ViewModelProvider.AndroidViewModelFactory(this.application)
    }

    /**
     * 显示 Toast 消息
     */
    fun showCenterToast(text: String) {
        ToastUtils.make().showCenter(text)
    }

    fun showWaitDialog(content: String) {
        hideWaitDialog()
        QuickWaitDialog(content).showCenter().also { waitDialog = it as QuickWaitDialog }
    }

    fun hideWaitDialog() {
        waitDialog?.dismiss()
        waitDialog = null;
    }


    /**
     * 分发Touch事件，若touch的区域不在EditText上，则隐藏软键盘
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus
            if (shouldHideInput(view, ev)) {
                KeyboardUtils.hideSoftInput(view!!)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    /**
     * 判断是否需要隐藏软键盘
     * @param view
     * @param event
     * @return
     */
    open fun shouldHideInput(view: View?, event: MotionEvent): Boolean {
        if (view != null && view is EditText) {
            val leftTop = intArrayOf(0, 0)
            view.getLocationInWindow(leftTop)
            val left = leftTop[0]
            val top = leftTop[1]
            val bottom = top + view.getHeight()
            val right = (left
                    + view.getWidth())
            return !(event.x > left && event.x < right && event.y > top && event.y < bottom)
        }
        return false
    }
}