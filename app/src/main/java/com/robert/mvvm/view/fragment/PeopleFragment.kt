package com.robert.mvvm.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.robert.mvvm.R
import com.robert.mvvm.databinding.FragmentPeopleBinding
import com.robert.mvvm.utils.LogUtils
import com.robert.mvvm.view.PeopleAdapter
import com.robert.mvvm.viewmodel.PeopleViewModel
import java.util.*

class PeopleFragment: Fragment(), Observer {
    private var peopleViewModel: PeopleViewModel? = null
    private var binding: FragmentPeopleBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_people, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataBinding()
        setupListPeopleView(binding!!.recyclerPeople)
        setupObserver(peopleViewModel)
    }

    private fun initDataBinding() {
        peopleViewModel = PeopleViewModel(activity!!)
        binding?.mainViewModel = peopleViewModel
    }

    private fun setupListPeopleView(recyclerPeople: RecyclerView) {
        val adapter = PeopleAdapter()
        recyclerPeople.adapter = adapter
        recyclerPeople.setHasFixedSize(true)
    }

    private fun setupObserver(observable: Observable?) {
        observable!!.addObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        peopleViewModel!!.reset()
    }

    override fun update(observable: Observable, data: Any) {
        if (observable is PeopleViewModel) {
            LogUtils.e("--->observable.peopleList.size=${observable.peopleList.size}")
            val peopleAdapter: PeopleAdapter? = binding?.recyclerPeople?.adapter as PeopleAdapter?
            peopleAdapter?.setPeopleList(observable.peopleList)
        }
    }
}