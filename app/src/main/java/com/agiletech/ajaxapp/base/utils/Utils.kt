package com.agiletech.ajaxapp.base.utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.DisplayMetrics
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.agiletech.ajaxapp.R

class Utils {

    companion object {

        fun showSoftKeyboard(context: Context, view: View) {
            val inputMethod = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethod.showSoftInput(view, InputMethod.SHOW_EXPLICIT)
        }

        fun hideSoftKeyboard(context: Context, view: View) {
            val inputMethod = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethod.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun reportToastMessage(context: Context?, message: String) {
            context?.let {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }

        fun reportToastMessage(context: Context?, messageId: Int) {
            context?.let {
                Toast.makeText(context, context.getString(messageId), Toast.LENGTH_SHORT).show()
            }
        }

        fun pxToDp(context: Context, px: Int): Int {
            val displayMetrics = context.resources.displayMetrics
            return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
        }

        fun dpToPx(context: Context, dp: Int): Int {
            val displayMetrics = context.resources.displayMetrics
            return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
        }

        fun checkNetworkConnectedAndNotify(context: Context, shouldNotify: Boolean = true): Boolean {
            val networkManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = networkManager.activeNetworkInfo
            if (networkInfo != null && networkInfo.isConnected) {
                return true
            } else {
                if (shouldNotify) {
                    Toast.makeText(context, R.string.msg_network_is_not_available, Toast.LENGTH_SHORT).show()
                }
                return false
            }
        }
    }
}