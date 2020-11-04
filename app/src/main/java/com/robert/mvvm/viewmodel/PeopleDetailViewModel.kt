package com.robert.mvvm.viewmodel

import android.view.View
import com.robert.mvvm.model.People

class PeopleDetailViewModel(private val people: People) {
    val fullUserName: String?
        get() = people.fullName

    val userName: String?
        get() = people.login!!.userName

    val email: String?
        get() = people.mail

    val emailVisibility: Int
        get() = if (people.hasEmail()) View.VISIBLE else View.GONE

    val cell: String?
        get() = people.cell

    val pictureProfile: String?
        get() = people.picture!!.large

    val address: String
        get() = (people.location!!.street!!.name
                + " "
                + people.location!!.street!!.number + " "
                + people.location!!.city
                + " "
                + people.location!!.state)

    val gender: String?
        get() = people.gender

}