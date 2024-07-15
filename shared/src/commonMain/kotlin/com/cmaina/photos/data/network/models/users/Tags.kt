package com.cmaina.photos.data.network.models.users

import com.cmaina.photos.data.network.models.specificphoto.Tag
import com.cmaina.photos.data.network.models.users.Custom
import kotlinx.serialization.SerialName


data class Tags(
    @SerialName("aggregated")
    val aggregated: List<Tag>,
    @SerialName("custom")
    val custom: List<Custom>
)