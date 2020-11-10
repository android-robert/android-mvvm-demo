package com.robert.mvvm.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robert.mvvm.R
import com.robert.mvvm.view.BaseFragment

class TimelineFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_timeline, container, false)
    }

    companion object {
        fun newInstance(bundle: Bundle): BaseFragment {
            val fragment = TimelineFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}