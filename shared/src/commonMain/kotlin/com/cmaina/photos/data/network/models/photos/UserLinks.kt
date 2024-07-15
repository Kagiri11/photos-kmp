package com.cmaina.photos.data.network.models.photos

data class UserLinks(
    val followers: String,
    val following: String,
    val html: String,
    val likes: String,
    val photos: String,
    val portfolio: String,
    val self: String
)