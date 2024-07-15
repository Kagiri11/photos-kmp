package com.cmaina.photos.data.network.models.specificphoto

import kotlinx.serialization.SerialName

data class Location(
    @SerialName("city")
    val city: Any,
    @SerialName("country")
    val country: Any,
    @SerialName("name")
    val name: Any,
    @SerialName("position")
    val position: Position?,
    @SerialName("title")
    val title: Any
)