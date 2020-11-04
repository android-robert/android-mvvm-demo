package com.robert.mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class People : Serializable {
    @SerializedName("gender")
    val gender: String? = null

    @SerializedName("name")
    var name: Name? = null

    @SerializedName("location")
    var location: Location? = null

    @SerializedName("email")
    var mail: String? = null

    @SerializedName("login")
    var login: Login? = null

    @SerializedName("cell")
    var cell: String? = null

    @SerializedName("picture")
    var picture: Picture? = null
    val fullName: String?
        get() = name?.title + "." + name?.first + " " + name?.last

    fun hasEmail(): Boolean {
        return mail != null && !mail!!.isEmpty()
    }
}