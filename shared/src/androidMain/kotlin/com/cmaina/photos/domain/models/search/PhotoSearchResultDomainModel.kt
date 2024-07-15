package com.cmaina.photos.domain.models.search

import com.cmaina.photos.domain.models.photos.Photo

data class PhotoSearchResultDomainModel(
    val searchedPhotoDomainModels: List<Photo>?,
    val total: Int?,
    val totalPages: Int?
)
