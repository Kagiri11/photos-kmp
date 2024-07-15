package com.cmaina.photos.data.network.models.users

import com.cmaina.photos.data.network.models.specificphoto.Source

data class Custom(
    val source: Source,
    val title: String,
    val type: String
)