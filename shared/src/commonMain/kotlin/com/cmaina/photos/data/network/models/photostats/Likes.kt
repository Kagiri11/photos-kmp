package com.cmaina.photos.data.network.models.photostats

import com.cmaina.photos.data.network.models.photostats.Historical

data class Likes(
    val historical: Historical,
    val total: Int
)
