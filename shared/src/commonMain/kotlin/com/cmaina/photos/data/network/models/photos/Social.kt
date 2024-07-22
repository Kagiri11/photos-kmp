package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.Serializable

@Serializable
data class Social(
    val instagram_username: String,
    val portfolio_url: String,
    val twitter_username: String
)
