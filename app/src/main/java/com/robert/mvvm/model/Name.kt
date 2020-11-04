package com.robert.mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Name : Serializable {
    @SerializedName("title")
    var title: String? = null

    @SerializedName("first")
    var first: String? = null

    @SerializedName("last")
    var last: String? = null

}