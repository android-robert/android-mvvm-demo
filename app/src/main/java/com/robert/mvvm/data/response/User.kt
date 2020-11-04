package com.robert.mvvm.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("result")
    @Expose
    var result: UserResult? = null
    @SerializedName("status")
    @Expose
    var status: Boolean? = null

}
