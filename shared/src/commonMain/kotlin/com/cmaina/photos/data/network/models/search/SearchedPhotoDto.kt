package com.cmaina.photos.data.network.models.search

import com.cmaina.photos.data.network.models.photos.Collections
import com.cmaina.photos.data.network.models.photos.PhotoLinks
import com.cmaina.photos.data.network.models.photos.Urls
import com.cmaina.photos.domain.models.users.User

data class SearchedPhotoDto(
    val altDescription: String,
    val blurHash: String,
    val categories: List<Any>,
    val color: String,
    val createdAt: String,
    val currentUserCollections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val likedByUser: Boolean,
    val likes: Int,
    val links: PhotoLinks,
    val promotedAt: String,
    val updatedAt: String,
    val urls: Urls,
    val user: User,
    val width: Int,
    val collections: Collections
)
