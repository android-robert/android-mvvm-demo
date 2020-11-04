package com.robert.mvvm.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResult {

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
    @SerializedName("gender")
    @Expose
    var gender: String? = null
    @SerializedName("comment")
    @Expose
    var comment: String? = null
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
    @SerializedName("user_photo_id")
    @Expose
    var userPhotoId: String? = null
    @SerializedName("user_photo_update")
    @Expose
    var userPhotoUpdate: String? = null
    @SerializedName("user_photo_background_id")
    @Expose
    var userPhotoBackgroundId: String? = null
    @SerializedName("user_photo_background_update")
    @Expose
    var userPhotoBackgroundUpdate: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("deleted_at")
    @Expose
    var deletedAt: String? = null
    @SerializedName("follow")
    @Expose
    var follow: List<Follow>? = null
    @SerializedName("follower")
    @Expose
    var follower: List<Follower>? = null
    @SerializedName("folders")
    @Expose
    var folders: List<Folder>? = null
    @SerializedName("keyword_historys")
    @Expose
    var keywordHistorys: List<KeywordHistory>? = null
    @SerializedName("browse_historys")
    @Expose
    var browseHistorys: List<BrowseHistory>? = null
    @SerializedName("system_configs")
    @Expose
    var systemConfigs: List<SystemConfig>? = null
    @SerializedName("is_following")
    @Expose
    var isFollow: Boolean? = null
    @SerializedName("is_private")
    @Expose
    var isPrivate: Boolean? = null
    @SerializedName("total_follows")
    @Expose
    var totalFollows: Int? = null
    @SerializedName("total_followers")
    @Expose
    var totalFollowers: Int? = null
    @SerializedName("total_likes")
    @Expose
    var totalLikes: Int? = null
    @SerializedName("total_reviews")
    @Expose
    var totalReviews: Int? = null
    @SerializedName("total_keeps")
    @Expose
    var totalKeeps: Int? = null
    @SerializedName("mentions")
    @Expose
    var mentions: ArrayList<UserData>? = null
    @SerializedName("is_guest")
    @Expose
    var isGuest: Int? = null

}
