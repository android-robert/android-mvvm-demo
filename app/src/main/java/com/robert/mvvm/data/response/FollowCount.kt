package com.robert.mvvm.data.response


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FollowCount {

    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("count")
    @Expose
    var count: String? = null
}