package com.cmaina.photos.data.network.models.users

import com.cmaina.photos.data.network.models.photos.PhotoListItem
import com.cmaina.photos.data.network.models.photos.Social
import com.cmaina.photos.data.network.models.photos.SponsorLinks
import com.cmaina.photos.data.network.models.specificphoto.Meta
import kotlinx.serialization.SerialName

data class UserDto(
    @SerialName("accepted_tos")
    val accepted_tos: Boolean,
    @SerialName("allow_messages")
    val allow_messages: Boolean,
    @SerialName("badge")
    val badge: Any,
    @SerialName("bio")
    val bio: String,
    @SerialName("downloads")
    val downloads: Int,
    @SerialName("first_name")
    val first_name: String,
    @SerialName("followed_by_user")
    val followed_by_user: Boolean,
    @SerialName("followers_count")
    val followers_count: Int,
    @SerialName("following_count")
    val following_count: Int,
    @SerialName("for_hire")
    val for_hire: Boolean,
    @SerialName("id")
    val id: String,
    @SerialName("instagram_username")
    val instagram_username: String,
    @SerialName("last_name")
    val last_name: Any,
    @SerialName("links")
    val links: SponsorLinks,
    @SerialName("location")
    val location: Any,
    @SerialName("meta")
    val meta: Meta,
    @SerialName("name")
    val name: String,
    @SerialName("numeric_id")
    val numeric_id: Int,
    @SerialName("photos")
    val photos: List<PhotoListItem>,
    @SerialName("portfolio_url")
    val portfolio_url: String,
    @SerialName("profile_image")
    val profile_image: ProfileImage,
    @SerialName("social")
    val social: Social,
    @SerialName("tags")
    val tags: Tags? = null,
    @SerialName("total_collections")
    val total_collections: Int,
    @SerialName("total_likes")
    val total_likes: Int,
    @SerialName("total_photos")
    val total_photos: Int,
    @SerialName("twitter_username")
    val twitter_username: String,
    @SerialName("updated_at")
    val updated_at: String,
    @SerialName("username")
    val username: String
)