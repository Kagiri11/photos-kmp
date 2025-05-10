package com.cmaina.photos.domain.models.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String?,
    @SerialName("bio")
    val bio: String?,
    @SerialName("last_name")
    val lastName: String?,
    @SerialName("for_hire")
    val forHire: Boolean?,
    @SerialName("username")
    val userName: String?,
    @SerialName("first_name")
    val firstName: String?,
    @SerialName("total_likes")
    val totalLikes: Int?,
    @SerialName("total_photos")
    val totalPhotos: Int?,
    @SerialName("instagram_username")
    val instagramUsername: String?,
    @SerialName("profile_image")
    val profileImage: ProfileImageDomainModel,
    @SerialName("downloads")
    val downloads: Int? = 0,
)
