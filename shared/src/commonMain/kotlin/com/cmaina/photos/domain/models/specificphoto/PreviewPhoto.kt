package com.cmaina.photos.domain.models.specificphoto

import com.cmaina.photos.domain.models.photos.PhotoUrls


data class PreviewPhoto(
    val blurHash: String?,
    val id: String?,
    val urls: com.cmaina.photos.domain.models.photos.PhotoUrls?
)
