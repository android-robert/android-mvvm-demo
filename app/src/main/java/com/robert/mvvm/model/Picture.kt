package com.robert.mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Picture : Serializable {
    @SerializedName("large")
    var large: String? = null

    @SerializedName("medium")
    val medium: String? = null

}