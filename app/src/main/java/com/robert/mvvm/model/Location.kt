package com.robert.mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Location : Serializable {
    @SerializedName("street")
    var street: Street? = null

    @SerializedName("city")
    var city: String? = null

    @SerializedName("state")
    var state: String? = null

}