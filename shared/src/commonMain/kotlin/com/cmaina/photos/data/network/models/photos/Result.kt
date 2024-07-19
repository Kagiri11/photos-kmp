package com.cmaina.photos.data.network.models.photos

import com.cmaina.photos.data.network.models.photos.CoverPhoto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("cover_photo")
    val coverPhoto: CoverPhoto,
    @SerialName("description")
    val description: String,
    @SerialName("featured")
    val featured: Boolean,
    @SerialName("id")
    val id: String,
    @SerialName("published_at")
    val publishedAt: String,
    @SerialName("share_key")
    val shareKey: String,
    @SerialName("title")
    val title: String,
    @SerialName("total_photos")
    val totalPhotos: Int,
    @SerialName("updated_at")
    val updatedAt: String
)