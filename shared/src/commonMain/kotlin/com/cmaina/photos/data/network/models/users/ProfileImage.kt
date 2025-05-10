package com.cmaina.photos.data.network.models.users

import kotlinx.serialization.Serializable

@Serializable
data class ProfileImage(
    val large: String,
    val medium: String,
    val small: String
)