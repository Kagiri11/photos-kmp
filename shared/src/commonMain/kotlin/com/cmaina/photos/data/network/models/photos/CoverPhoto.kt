package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.SerialName

data class CoverPhoto(
    @SerialName("alt_description")
    val altDescription: String,
    @SerialName("blur_hash")
    val blurHash: String,
    val breadcrumbs: List<Any>,
    val color: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("current_user_collections")
    val currentUserCollections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    @SerialName("liked_by_user")
    val likedByUser: Boolean,
    val likes: Int,
    @SerialName("promoted_at")
    val promotedAt: String,
    val slug: String,
    val sponsorship: Any,
    @SerialName("updated_at")
    val updatedAt: String,
    val urls: Urls,
    val user: User,
    val width: Int
)