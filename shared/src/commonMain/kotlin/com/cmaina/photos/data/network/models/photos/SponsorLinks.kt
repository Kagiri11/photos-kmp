package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.Serializable

@Serializable
data class SponsorLinks(
    val followers: String,
    val following: String,
    val html: String,
    val likes: String,
    val photos: String,
    val portfolio: String,
    val self: String
)
