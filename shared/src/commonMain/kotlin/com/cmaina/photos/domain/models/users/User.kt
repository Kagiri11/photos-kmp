package com.cmaina.photos.domain.models.users

import com.cmaina.photos.domain.models.photos.DomainUserSocial
import com.cmaina.photos.domain.models.photos.Photo

data class User(
    val bio: String,
    val downloads: Int,
    val firstName: String?,
    val followedByUser: Boolean,
    val followersCount: Int,
    val followingCount: Int,
    val forHire: Boolean,
    val id: String,
    val instagramUsername: String,
    val lastName: String,
    val name: String,
    val userPhotos: List<com.cmaina.photos.domain.models.photos.Photo>,
    val profileImage: com.cmaina.photos.domain.models.users.ProfileImageDomainModel,
    val social: com.cmaina.photos.domain.models.photos.DomainUserSocial,
    val totalLikes: Int,
    val totalPhotos: Int,
    val username: String
)
