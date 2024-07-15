package com.cmaina.photos.domain.models.photostats

data class DomainPhotoStatHistorical(
    val change: Int?,
    val quantity: Int?,
    val resolution: String?,
    val domainPhotoStatsValues: List<DomainPhotoStatsValue>?
)