package com.cmaina.photos.data.network.models.photos

import com.cmaina.photos.domain.models.users.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoverPhoto(
    @SerialName("alt_description")
    val altDescription: String,
    @SerialName("blur_hash")
    val blurHash: String,
    @SerialName("color")
    val color: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("description")
    val description: String,
    @SerialName("height")
    val height: Int,
    @SerialName("id")
    val id: String,
    @SerialName("liked_by_user")
    val likedByUser: Boolean,
    @SerialName("likes")
    val likes: Int,
    @SerialName("promoted_at")
    val promotedAt: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("urls")
    val urls: Urls,
    @SerialName("user")
    val user: User,
    @SerialName("width")
    val width: Int
)