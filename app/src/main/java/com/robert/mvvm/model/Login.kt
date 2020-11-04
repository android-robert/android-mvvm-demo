package com.robert.mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Login : Serializable {
    @SerializedName("username")
    var userName: String? = null

}