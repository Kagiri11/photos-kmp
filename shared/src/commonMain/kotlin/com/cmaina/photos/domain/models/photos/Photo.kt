package com.cmaina.photos.domain.models.photos

import com.cmaina.photos.domain.models.users.User


data class Photo(
    val id: String,
    val blurHash: String,
    val description: String,
    val photoUrls: PhotoUrls,
    val likedByUser: Boolean,
    val likes: Int,
    val user: User?,
    val relatedPhotos: List<Pair<String, String>> = emptyList()
)


