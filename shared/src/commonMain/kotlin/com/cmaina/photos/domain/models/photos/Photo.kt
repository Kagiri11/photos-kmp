package com.cmaina.photos.domain.models.photos


data class Photo(
    val id: String,
    val blurHash: String,
    val description: String,
    val photoUrls: com.cmaina.photos.domain.models.photos.PhotoUrls,
    val likedByUser: Boolean,
    val likes: Int,
    val user: com.cmaina.photos.domain.models.photos.PhotoUser,
    val relatedPhotos: List<Pair<String, String>>
)


