package com.robert.mvvm.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robert.mvvm.R
import com.robert.mvvm.view.BaseActivity
import com.robert.mvvm.view.BaseFragment

class ChatFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    companion object {
        fun newInstance(baseActivity: BaseActivity, bundle: Bundle): BaseFragment {
            val fragment = ChatFragment()
            fragment.arguments = bundle
            fragment.baseActivity = baseActivity
            return fragment
        }
    }
}