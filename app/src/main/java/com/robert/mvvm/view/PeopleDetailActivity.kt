package com.robert.mvvm.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.robert.mvvm.R
import com.robert.mvvm.databinding.PeopleDetailActivityBinding
import com.robert.mvvm.model.People
import com.robert.mvvm.viewmodel.PeopleDetailViewModel

class PeopleDetailActivity : AppCompatActivity() {
    private var binding: PeopleDetailActivityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.people_detail_activity)
        setSupportActionBar(binding?.toolbar)
        displayHomeAsUpEnabled()
        extrasFromIntent
    }

    private fun displayHomeAsUpEnabled() {
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private val extrasFromIntent: Unit
        private get() {
            val people = intent.getSerializableExtra(EXTRA_PEOPLE) as People
            val peopleDetailViewModel = PeopleDetailViewModel(people)
            binding!!.peopleDetailViewModel = peopleDetailViewModel
            title = people.name!!.title + "." + people.name!!.first + " " + people.name!!.last
        }

    companion object {
        private const val EXTRA_PEOPLE = "EXTRA_PEOPLE"
        fun launchDetail(context: Context?, people: People?): Intent {
            val intent = Intent(context, PeopleDetailActivity::class.java)
            intent.putExtra(EXTRA_PEOPLE, people)
            return intent
        }
    }
}