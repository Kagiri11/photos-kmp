package com.cmaina.photos.data.network.models.specificphoto

import kotlinx.serialization.SerialName

data class Tag(
    @SerialName("source")
    val source: Source,
    @SerialName("title")
    val title: String? = null,
    @SerialName("type")
    val type: String? = null
)
