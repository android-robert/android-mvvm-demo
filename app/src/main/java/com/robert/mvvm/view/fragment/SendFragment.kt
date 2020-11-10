package com.robert.mvvm.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robert.mvvm.R
import com.robert.mvvm.view.BaseFragment

class SendFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_send, container, false)
    }

    companion object {
        fun newInstance(bundle: Bundle): BaseFragment {
            val fragment = SendFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}