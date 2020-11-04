package com.robert.mvvm.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Folder {

    @SerializedName("folder_id")
    @Expose
    var folderId: String? = null
    @SerializedName("folder_number")
    @Expose
    var folderNumber: String? = null
    @SerializedName("folder_name")
    @Expose
    var folderName: String? = null
    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("folder_photo_id")
    @Expose
    var folderPhotoId: String? = null
    @SerializedName("keep_data")
    @Expose
    var keepData: List<KeepDatum>? = null


}
