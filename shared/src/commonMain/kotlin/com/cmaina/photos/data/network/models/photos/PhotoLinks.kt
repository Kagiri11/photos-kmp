package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.SerialName


data class PhotoLinks(
    @SerialName("download")
    val download: String?,
    @SerialName("download_location")
    val downloadLocation: String?,
    @SerialName("html")
    val html: String?,
    @SerialName("self")
    val self: String?
)