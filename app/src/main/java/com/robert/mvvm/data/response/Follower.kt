package com.robert.mvvm.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Follower {

    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("follow_user_id")
    @Expose
    var followUserId: String? = null
    @SerializedName("follower_user")
    @Expose
    var followerUser: FollowerUser? = null

    fun withUserId(userId: String): Follower {
        this.userId = userId
        return this
    }

}
