package com.robert.mvvm.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.robert.mvvm.R
import com.robert.mvvm.databinding.FragmentTimelineBindingImpl
import com.robert.mvvm.view.BaseActivity
import com.robert.mvvm.view.BaseFragment
import com.robert.mvvm.viewmodel.PeopleViewModel
import com.robert.mvvm.viewmodel.TimelineViewModel

class TimelineFragment: BaseFragment() {
    private var timelineViewModel: TimelineViewModel? = null
    private var binding: FragmentTimelineBindingImpl? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_timeline, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataBinding()
    }

    private fun initDataBinding() {
        timelineViewModel = TimelineViewModel(baseActivity!!, baseActivity!!)
        binding?.timelineViewModel = timelineViewModel
    }

    companion object {
        fun newInstance(baseActivity: BaseActivity, bundle: Bundle): BaseFragment {
            val fragment = TimelineFragment()
            fragment.arguments = bundle
            fragment.baseActivity = baseActivity
            return fragment
        }
    }
}