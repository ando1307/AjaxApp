package com.agiletech.ajaxapp.base.activity

import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.widget.EditText
import com.agiletech.ajaxapp.base.utils.Utils

open class BaseActivity : AppCompatActivity() {

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            if (event.action == MotionEvent.ACTION_UP) {
                val view = currentFocus
                if (view is EditText) {
                    val scrcoords = IntArray(2)
                    view.getLocationOnScreen(scrcoords)
                    val x = event.rawX
                    val y = event.rawY

                    if (x < scrcoords[0] || x >= scrcoords[0] + view.getMeasuredWidth()
                        || y < scrcoords[1] || y > scrcoords[1] + view.getMeasuredHeight()) {
                        view.clearFocus()
                        Utils.hideSoftKeyboard(this, view)
                    }
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }
}