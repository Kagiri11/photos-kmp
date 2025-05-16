package com.cmaina.photos.data.network.models.specificphoto

import kotlinx.serialization.Serializable

@Serializable
data class RelatedCollections(
//    val results: List<Result>,
    val total: Int,
    val type: String
)