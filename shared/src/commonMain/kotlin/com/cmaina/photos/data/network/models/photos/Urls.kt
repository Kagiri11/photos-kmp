package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Urls(
    @SerialName("full")
    val full: String?,
    @SerialName("raw")
    val raw: String?,
    @SerialName("regular")
    val regular: String?,
    @SerialName("small")
    val small: String?,
    @SerialName("small_s3")
    val small_s3: String?,
    @SerialName("thumb")
    val thumb: String?
)
