package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoverPhoto(
    @SerialName("alt_description")
    val altDescription: String,
    @SerialName("blur_hash")
    val blurHash: String,
    val color: String,
    @SerialName("created_at")
    val createdAt: String,
    val description: String,
    val height: Int,
    val id: String,
    @SerialName("liked_by_user")
    val likedByUser: Boolean,
    val likes: Int,
    @SerialName("promoted_at")
    val promotedAt: String,
    val slug: String,
    @SerialName("updated_at")
    val updatedAt: String,
    val urls: Urls,
    val user: User,
    val width: Int
)