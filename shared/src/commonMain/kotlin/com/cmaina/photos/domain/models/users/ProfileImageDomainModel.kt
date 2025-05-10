package com.cmaina.photos.domain.models.users

import kotlinx.serialization.Serializable

@Serializable
data class ProfileImageDomainModel(
    val large: String?,
    val medium: String?,
    val small: String?
)