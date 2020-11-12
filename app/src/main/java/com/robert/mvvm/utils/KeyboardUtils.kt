package com.robert.mvvm.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

object KeyboardUtils {
    /**
     * Hidden soft keyboard of current view focused
     *
     * @param activity
     */
    fun hideSoftKeyboard(activity: Activity?) {
        activity?: kotlin.run {
            return
        }
        val inputMethodManager = activity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = activity.currentFocus ?: return
        val iBinder = view.windowToken
        iBinder?.let {
            inputMethodManager.hideSoftInputFromWindow(it, 0)
        }
    }

    /**
     * Hidden soft keyboard of current view focused
     *
     * @param mContext
     */
    fun hideSoftKeyboard(mContext: Context?) {
        mContext?: kotlin.run {
            return
        }
        val inputMethodManager = mContext.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = (mContext as AppCompatActivity).currentFocus ?: return
        val iBinder = view.windowToken
        iBinder?.let {
            inputMethodManager.hideSoftInputFromWindow(it, 0)
        }
    }
}