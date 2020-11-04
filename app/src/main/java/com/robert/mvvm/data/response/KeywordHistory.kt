package com.robert.mvvm.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class KeywordHistory {

    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("keyword")
    @Expose
    var keyword: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

}
