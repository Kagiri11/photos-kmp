package com.cmaina.fotos.shared.data.network.models.specificphoto

import kotlinx.serialization.SerialName

data class Exif(
    @SerialName("aperture")
    val aperture: String?,
    @SerialName("exposure_time")
    val exposure_time: String?,
    @SerialName("focal_length")
    val focal_length: String?,
    @SerialName("iso")
    val iso: Int?,
    @SerialName("make")
    val make: String?,
    @SerialName("model")
    val model: String?,
    @SerialName("name")
    val name: String?
)