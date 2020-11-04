package com.robert.mvvm.utils

import android.util.Log
import com.robert.mvvm.BuildConfig

object LogUtils {

    private val TAG = "develop"
    private val isDebug = BuildConfig.DEBUG

    private val metaInfo: String
        get() {
            val element = Thread.currentThread().stackTrace[4]
            return LogUtils.getMetaInfo(element)
        }

    fun v() {
        if (isDebug) {
            Log.v(TAG, metaInfo)
        }
    }

    fun v(message: String) {
        if (isDebug) {
            Log.v(TAG, metaInfo + null2str(message))
        }
    }

    fun v(format: String, vararg args: Any) {
        if (isDebug) {
            Log.v(TAG, metaInfo + null2str(String.format(format, *args)))
        }
    }

    fun d() {
        if (isDebug) {
            Log.d(TAG, metaInfo)
        }
    }

    fun d(message: String) {
        if (isDebug) {
            Log.d(TAG, metaInfo + null2str(message))
        }
    }

    fun d(format: String, vararg args: Any?) {
        if (isDebug) {
            Log.d(TAG, metaInfo + null2str(String.format(format, *args)))
        }
    }

    fun i() {
        if (isDebug) {
            Log.i(TAG, metaInfo)
        }
    }

    fun i(message: String) {
        if (isDebug) {
            Log.i(TAG, metaInfo + null2str(message))
        }
    }

    fun i(format: String, vararg args: Any?) {
        if (isDebug) {
            Log.i(TAG, metaInfo + null2str(String.format(format, *args)))
        }
    }

    fun w(message: String?) {
        if (isDebug) {
            Log.w(TAG, metaInfo + null2str(message))
        }
    }

    fun w(format: String, vararg args: Any?) {
        if (isDebug) {
            Log.w(TAG, metaInfo + null2str(String.format(format, *args)))
        }
    }

    fun w(message: String, e: Throwable) {
        if (isDebug) {
            Log.w(TAG, metaInfo + null2str(message), e)
            printThrowable(e)
            if (e.cause != null) {
                printThrowable(e.cause!!)
            }
        }
    }

    fun e(message: String) {
        if (isDebug) {
            Log.e(TAG, metaInfo + null2str(message))
        }
    }

    fun e(format: String, vararg args: Any?) {
        if (isDebug) {
            Log.e(TAG, metaInfo + null2str(String.format(format, *args)))
        }
    }

    fun e(message: String, e: Throwable) {
        if (isDebug) {
            Log.e(TAG, metaInfo + null2str(message), e)
            printThrowable(e)
            if (e.cause != null) {
                printThrowable(e.cause!!)
            }
        }
    }

    fun e(e: Throwable) {
        if (isDebug) {
            printThrowable(e)
            if (e.cause != null) {
                printThrowable(e.cause!!)
            }
        }
    }

    private fun null2str(string: String?): String {
        return string ?: "(null)"
    }

    private fun printThrowable(e: Throwable?) {
        Log.e(TAG, e?.javaClass?.name + ": " + e?.message)
        for (element in e?.stackTrace!!) {
            Log.e(TAG, "  at " + LogUtils.getMetaInfo(element))
        }
    }

     fun getMetaInfo(element: StackTraceElement): String {
        val fullClassName = element.className
        val simpleClassName = fullClassName.substring(fullClassName.lastIndexOf(".") + 1)
        val methodName = element.methodName
        val lineNumber = element.lineNumber
        return "[$simpleClassName#$methodName:$lineNumber]"
    }

}