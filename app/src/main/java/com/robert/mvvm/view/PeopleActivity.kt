package com.robert.mvvm.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.robert.mvvm.R
import com.robert.mvvm.data.PeopleFactory
import com.robert.mvvm.databinding.PeopleActivityBinding
import com.robert.mvvm.utils.LogUtils
import com.robert.mvvm.viewmodel.PeopleViewModel
import java.util.*

class PeopleActivity : AppCompatActivity(), Observer {
    private var peopleViewModel: PeopleViewModel? = null
    private var binding: PeopleActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        setSupportActionBar(binding!!.toolbar)
        setupListPeopleView(binding!!.recyclerPeople)
        setupObserver(peopleViewModel)
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.people_activity)
        peopleViewModel = PeopleViewModel(this)
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_github) {
            startActivityActionView()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startActivityActionView() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(PeopleFactory.PROJECT_URL)))
    }

    override fun update(observable: Observable, data: Any) {

        if (observable is PeopleViewModel) {
            LogUtils.e("--->observable.peopleList.size=${observable.peopleList.size}")
            val peopleAdapter: PeopleAdapter? = binding?.recyclerPeople?.adapter as PeopleAdapter?
            peopleAdapter?.setPeopleList(observable.peopleList)
        }
    }

    companion object {
        fun launch(context: Context): Intent {
            return Intent(context, PeopleActivity::class.java)
        }
    }
}