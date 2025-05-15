package com.cmaina.photos.domain.models.photos

import kotlinx.serialization.Serializable

@Serializable
data class PhotoUrls(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String?
)
