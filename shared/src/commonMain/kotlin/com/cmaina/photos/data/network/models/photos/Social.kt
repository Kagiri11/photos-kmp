package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Social(
    @SerialName("instagram_username")
    val instagramUsername: String,
    @SerialName("portfolio_url")
    val portfolioUrl: String,
    @SerialName("twitter_username")
    val twitterUsername: String
)
