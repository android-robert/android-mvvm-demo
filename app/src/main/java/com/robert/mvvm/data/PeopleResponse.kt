package com.robert.mvvm.data

import com.google.gson.annotations.SerializedName
import com.robert.mvvm.model.People

class PeopleResponse {
    @SerializedName("results")
    val peopleList: List<People>? = null
}