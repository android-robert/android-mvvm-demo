package com.robert.mvvm.viewmodel

import android.content.Context
import android.view.View
import androidx.databinding.BaseObservable
import com.robert.mvvm.model.People
import com.robert.mvvm.view.PeopleDetailActivity

class ItemPeopleViewModel(private val context: Context, private var people: People) : BaseObservable() {
    val fullName: String
        get() = people.name!!.title + "." + people.name!!.first + " " + people.name!!.last

    val cell: String?
        get() = people.cell

    val mail: String?
        get() = people.mail

    val pictureProfile: String?
        get() = people.picture!!.medium

    fun onItemClick(view: View) {
        context.startActivity(PeopleDetailActivity.launchDetail(view.context, people))
    }

    fun setPeople(people: People) {
        this.people = people
        notifyChange()
    }

}