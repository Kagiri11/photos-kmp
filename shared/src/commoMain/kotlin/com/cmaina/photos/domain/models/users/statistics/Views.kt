package com.cmaina.photos.domain.models.users.statistics

import com.cmaina.photos.domain.models.users.statistics.UserHistorical

data class Views(
    val userHistorical: UserHistorical?,
    val total: Int?
)
