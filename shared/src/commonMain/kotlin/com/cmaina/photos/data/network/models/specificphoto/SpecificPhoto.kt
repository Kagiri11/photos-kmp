package com.cmaina.photos.data.network.models.specificphoto

import com.cmaina.photos.data.network.models.photos.PhotoLinks
import com.cmaina.photos.data.network.models.photos.RelatedCollections
import com.cmaina.photos.data.network.models.photos.Urls
import com.cmaina.photos.data.network.models.photos.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpecificPhoto(
    @SerialName("blur_hash")
    val blurHash: String?,
    @SerialName("color")
    val color: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: String,
    @SerialName("liked_by_user")
    val likedByUser: Boolean,
    @SerialName("likes")
    val likes: Int,
    @SerialName("urls")
    val urls: Urls,
    @SerialName("user")
    val user: User,
    @SerialName("related_collections")
    val relatedCollections: RelatedCollections
)
