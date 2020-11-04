package com.robert.mvvm.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BrowseHistory {

    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("shop_id")
    @Expose
    var shopId: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

}
