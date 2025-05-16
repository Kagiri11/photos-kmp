package com.cmaina.photos.domain.models.photos

import com.cmaina.photos.data.network.models.specificphoto.RelatedCollections
import com.cmaina.photos.domain.models.users.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Photo(
    @SerialName("id")
    val id: String,
    @SerialName("blur_hash")
    val blurHash: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("urls")
    val photoUrls: PhotoUrls,
    @SerialName("liked_by_user")
    val likedByUser: Boolean? = false,
    @SerialName("likes")
    val likes: Int,
    @SerialName("user")
    val user: User?,
    @SerialName("related_collections")
    val relatedCollections: RelatedCollections? = null,
)


