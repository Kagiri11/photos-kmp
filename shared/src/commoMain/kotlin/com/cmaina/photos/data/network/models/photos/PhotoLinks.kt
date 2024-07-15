package com.cmaina.fotos.shared.data.network.models.photos

import com.google.gson.annotations.SerializedName

data class PhotoLinks(
    @SerializedName("download")
    val download: String?,
    @SerializedName("download_location")
    val downloadLocation: String?,
    @SerializedName("html")
    val html: String?,
    @SerializedName("self")
    val self: String?
)