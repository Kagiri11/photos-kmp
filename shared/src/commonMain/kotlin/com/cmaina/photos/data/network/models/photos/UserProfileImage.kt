package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.Serializable

@Serializable
data class UserProfileImage(
    val large: String,
    val medium: String,
    val small: String
)