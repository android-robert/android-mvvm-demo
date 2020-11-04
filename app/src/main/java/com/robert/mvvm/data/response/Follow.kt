package com.robert.mvvm.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Follow {

    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("follow_user_id")
    @Expose
    var followUserId: String? = null
    @SerializedName("follow_user")
    @Expose
    var followUser: FollowUser? = null

}
