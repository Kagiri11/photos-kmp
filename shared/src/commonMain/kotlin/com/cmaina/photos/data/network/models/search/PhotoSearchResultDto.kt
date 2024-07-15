package com.cmaina.photos.data.network.models.search

data class PhotoSearchResultDto(
    val results: List<SearchedPhotoDto>,
    val total: Int,
    val total_pages: Int
)
