package com.robert.mvvm.data.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by trieunh on 7/20/18.
 */

class ReviewCount {

    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("count")
    @Expose
    var count: String? = null
}

class UserData() : Parcelable {

    @SerializedName("user_id")
    @Expose
    var userId: String? = null

    @SerializedName("is_keep")
    @Expose
    var isKeep: Int = 0

    @SerializedName("keep_id")
    @Expose
    var keepId: String? = null
    @SerializedName("user_name")
    @Expose
    var userName: String? = null
    @SerializedName("user_kana")
    @Expose
    var userKana: String? = null

    @SerializedName("gender")
    @Expose
    var gender: String? = null

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
    @SerializedName("pref_code")
    @Expose
    var prefCode: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("is_guest")
    @Expose
    var isGuest: Int = 0

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
    @SerializedName("is_following")
    @Expose
    var isFollow: Boolean? = null
    @SerializedName("user_photo_background_id")
    @Expose
    var userPhotoBackgroundId: String? = null
    @SerializedName("user_photo_background_update")
    @Expose
    var userPhotoBackgroundUpdate: String? = null
    @SerializedName("follow_count")
    @Expose
    var followCount: FollowCount? = null

    @SerializedName("follower")
    @Expose
    var follower: List<Follower>? = null

    @SerializedName("follower_count")
    @Expose
    var followerCount: FollowerCount? = null

    @SerializedName("review_count")
    @Expose
    var reviewCount: ReviewCount? = null

    @SerializedName("comment")
    @Expose
    var comment: String? = null

    constructor(parcel: Parcel) : this() {
        userId = parcel.readString()
        isKeep = parcel.readInt()
        keepId = parcel.readString()
        userName = parcel.readString()
        isGuest = parcel.readInt()
        gender = parcel.readString()
        userKana = parcel.readString()
        userFacebookId = parcel.readString()
        userTwitterId = parcel.readString()
        userLineId = parcel.readString()
        areaId = parcel.readString()
        userPhotoId = parcel.readString()
        url = parcel.readString()
        userPhotoUpdate = parcel.readString()
        createdAt = parcel.readString()
        updatedAt = parcel.readString()
        deletedAt = parcel.readString()
        isFollow = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        userPhotoBackgroundId = parcel.readString()
        userPhotoBackgroundUpdate = parcel.readString()
        comment = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userId)
        parcel.writeValue(isKeep)
        parcel.writeString(keepId)
        parcel.writeString(userName)
        parcel.writeInt(isGuest)
        parcel.writeString(gender)
        parcel.writeString(userKana)
        parcel.writeString(userFacebookId)
        parcel.writeString(userTwitterId)
        parcel.writeString(userLineId)
        parcel.writeString(areaId)
        parcel.writeString(userPhotoId)
        parcel.writeString(url)
        parcel.writeString(userPhotoUpdate)
        parcel.writeString(createdAt)
        parcel.writeString(updatedAt)
        parcel.writeString(deletedAt)
        parcel.writeValue(isFollow)
        parcel.writeString(userPhotoBackgroundId)
        parcel.writeString(userPhotoBackgroundUpdate)
        parcel.writeString(comment)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserData> {
        override fun createFromParcel(parcel: Parcel): UserData {
            return UserData(parcel)
        }

        override fun newArray(size: Int): Array<UserData?> {
            return arrayOfNulls(size)
        }
    }
}
