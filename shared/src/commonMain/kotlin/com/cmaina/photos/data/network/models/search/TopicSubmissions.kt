package com.cmaina.photos.data.network.models.search

import com.cmaina.photos.data.network.models.specificphoto.TexturesPatterns
import com.cmaina.photos.data.network.models.specificphoto.Wallpapers
import kotlinx.serialization.SerialName

data class TopicSubmissions(
    @SerialName("architecture")
    val architecture: Architecture?,
    @SerialName("artsCulture")
    val artsCulture: ArtsCulture?,
    @SerialName("colorOfWater")
    val colorOfWater: ColorOfWater?,
    @SerialName("history")
    val history: History?,
    @SerialName("texturesPatterns")
    val texturesPatterns: TexturesPatterns?,
    @SerialName("wallpapers")
    val wallpapers: Wallpapers?
)
