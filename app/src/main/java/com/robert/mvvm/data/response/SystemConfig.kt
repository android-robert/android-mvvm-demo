package com.robert.mvvm.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SystemConfig {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("key")
    @Expose
    var key: String? = null
    @SerializedName("value")
    @Expose
    var value: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

}
