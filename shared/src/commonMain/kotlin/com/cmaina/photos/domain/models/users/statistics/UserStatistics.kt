package com.cmaina.photos.domain.models.users.statistics

import com.cmaina.photos.domain.models.photostats.DomainPhotoStatDownloads

data class UserStatistics(
    val domainPhotoStatDownloads: com.cmaina.photos.domain.models.photostats.DomainPhotoStatDownloads?,
    val id: String?,
    val username: String?,
    val views: com.cmaina.photos.domain.models.users.statistics.Views?
)
