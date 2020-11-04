package com.robert.mvvm.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FollowerUser {

    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("keep_id")
    @Expose
    var keepId: String? = null
    @SerializedName("user_name")
    @Expose
    var userName: String? = null
    @SerializedName("user_kana")
    @Expose
    var userKana: String? = null
    @SerializedName("user_facebook_id")
    @Expose
    var userFacebookId: String? = null
    @SerializedName("user_twitter_id")
    @Expose
    var userTwitterId: String? = null
    @SerializedName("user_line_id")
    @Expose
    var userLineId: String? = null
    @SerializedName("area_id")
    @Expose
    var areaId: String? = null
    @SerializedName("user_photo_id")
    @Expose
    var userPhotoId: String? = null
    @SerializedName("user_photo_update")
    @Expose
    var userPhotoUpdate: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("deleted_at")
    @Expose
    var deletedAt: String? = null

    fun withUserId(userId: String): FollowerUser {
        this.userId = userId
        return this
    }

}
