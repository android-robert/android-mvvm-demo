package com.robert.mvvm.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.robert.mvvm.utils.LogUtils

open class BaseFragment: Fragment() {
    val CURR_FRAGMENT_TAG = javaClass.simpleName
    lateinit var mChangeFragmentListener: ChangeFragmentListener

    interface ChangeFragmentListener {
        fun changeFragment(fragment: BaseFragment, animation: Int)
        fun replaceFragment(fragment: BaseFragment, animation: Int, tag: String)
        fun popBackStackInclusiveFragment(stackName: String)
        fun popBackStackFragment(stackName: String)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogUtils.i("onCreateView...");
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtils.i("onAttach...")
        if (context !is ChangeFragmentListener) {
            throw ClassCastException("Activity does not implement ChangeFragmentListener")
        }

        mChangeFragmentListener = context

    }
}