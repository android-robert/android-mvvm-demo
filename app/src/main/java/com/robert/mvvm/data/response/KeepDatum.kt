package com.robert.mvvm.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class KeepDatum {

    @SerializedName("folder_id")
    @Expose
    var folderId: String? = null
    @SerializedName("shop_id")
    @Expose
    var shopId: String? = null
    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("keep_status_id")
    @Expose
    var keepStatusId: String? = null
    @SerializedName("main_folder_flg")
    @Expose
    var mainFolderFlg: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

}
