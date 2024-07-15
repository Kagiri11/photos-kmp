package com.cmaina.photos.data.network.models.photos

import com.cmaina.photos.data.network.models.search.TopicSubmissions
import com.cmaina.fotos.shared.data.network.models.specificphoto.Exif
import com.cmaina.photos.data.network.models.specificphoto.Location
import kotlinx.serialization.SerialName

data class PhotoListItem(
    @SerialName("alt_description")
    val altDescription: String?,
    @SerialName("blur_hash")
    val blurHash: String?,
    @SerialName("categories")
    val categories: List<Any>?,
    @SerialName("color")
    val color: String?,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("current_user_collections")
    val currentUserCollections: List<Any>?,
    @SerialName("description")
    val description: String?,
    @SerialName("height")
    val height: Int?,
    @SerialName("id")
    val id: String,
    @SerialName("liked_by_user")
    val likedByUser: Boolean?,
    @SerialName("likes")
    val likes: Int?,
    @SerialName("links")
    val links: PhotoLinks?,
    @SerialName("promoted_at")
    val promotedAt: String?,
    @SerialName("sponsorship")
    val sponsorship: Sponsorship?,
    @SerialName("topic_submissions")
    val topicSubmissions: TopicSubmissions?,
    @SerialName("updated_at")
    val updatedAt: String?,
    @SerialName("urls")
    val urls: Urls?,
    @SerialName("user")
    val user: User?,
    @SerialName("width")
    val width: Int?,
    // you can exclude these
    @SerialName("exif")
    val exif: Exif?,
    @SerialName("location")
    val location: Location?,
    @SerialName("views")
    val views: Int?,
    @SerialName("downloads")
    val downloads: Int?,
    @SerialName("related_collections")
    val collections: Collections
)
