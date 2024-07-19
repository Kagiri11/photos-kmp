package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("accepted_tos")
    val accepted_tos: Boolean?,
    @SerialName("bio")
    val bio: String?,
    @SerialName("first_name")
    val first_name: String?,
    @SerialName("for_hire")
    val for_hire: Boolean?,
    @SerialName("id")
    val id: String?,
    @SerialName("instagram_username")
    val instagram_username: String?,
    @SerialName("last_name")
    val last_name: String?,
    @SerialName("userLinks")
    val userLinks: UserLinks?,
    @SerialName("location")
    val location: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("portfolio_url")
    val portfolio_url: String?,
    @SerialName("profile_image")
    val userProfileImage: UserProfileImage,
    @SerialName("social")
    val social: Social?,
    @SerialName("total_collections")
    val total_collections: Int?,
    @SerialName("total_likes")
    val total_likes: Int?,
    @SerialName("total_photos")
    val total_photos: Int?,
    @SerialName("twitter_username")
    val twitter_username: String?,
    @SerialName("updated_at")
    val updated_at: String?,
    @SerialName("username")
    val username: String?
)
