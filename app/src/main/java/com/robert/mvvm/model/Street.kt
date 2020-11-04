package com.robert.mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Street : Serializable {
    @SerializedName("number")
    val number: String? = null

    @SerializedName("name")
    val name: String? = null

}