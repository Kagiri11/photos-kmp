package com.cmaina.photos.domain.models.users.statistics

data class UserHistorical(
    val average: Int?,
    val change: Int?,
    val quantity: Int?,
    val resolution: String?,
    val values: List<com.cmaina.photos.domain.models.users.statistics.Value>?
)
