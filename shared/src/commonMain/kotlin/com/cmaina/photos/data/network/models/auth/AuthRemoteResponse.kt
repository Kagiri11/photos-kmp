package com.cmaina.photos.data.network.models.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthRemoteResponse(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("created_at")
    val createdAt: Int,
    @SerialName("scope")
    val scope: String,
    @SerialName("token_type")
    val tokenType: String
)
