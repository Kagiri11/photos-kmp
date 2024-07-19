package com.cmaina.photos.data.network.models.photos

import kotlinx.serialization.Serializable

@Serializable
data class Collections(
    val results: List<Result>,
    val total: Int,
    val type: String
)