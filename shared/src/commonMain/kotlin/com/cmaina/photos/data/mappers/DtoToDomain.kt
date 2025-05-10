package com.cmaina.photos.data.mappers

import com.cmaina.photos.data.network.models.auth.AuthRemoteResponse
import com.cmaina.photos.data.network.models.photos.PhotoListItem
import com.cmaina.photos.data.network.models.photos.ProfileImage
import com.cmaina.photos.data.network.models.photos.Social
import com.cmaina.photos.data.network.models.photos.Urls
import com.cmaina.photos.data.network.models.photos.UserProfileImage
import com.cmaina.photos.data.network.models.photostats.Downloads
import com.cmaina.photos.data.network.models.photostats.Likes
import com.cmaina.photos.data.network.models.photostats.PhotoStatistics
import com.cmaina.photos.data.network.models.photostats.Views
import com.cmaina.photos.data.network.models.search.PhotoSearchResultDto
import com.cmaina.photos.data.network.models.search.SearchedPhotoDto
import com.cmaina.photos.domain.models.auth.AuthDomainResponse
import com.cmaina.photos.domain.models.photos.DomainProfileImage
import com.cmaina.photos.domain.models.photos.DomainUserProfileImage
import com.cmaina.photos.domain.models.photos.DomainUserSocial
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.domain.models.photos.PhotoUrls
import com.cmaina.photos.domain.models.photos.PhotoUser
import com.cmaina.photos.domain.models.photostats.DomainPhotoStatDownloads
import com.cmaina.photos.domain.models.photostats.DomainPhotoStatLikes
import com.cmaina.photos.domain.models.photostats.DomainPhotoStatistics
import com.cmaina.photos.domain.models.photostats.DomainPhotoStatsViews
import com.cmaina.photos.domain.models.search.PhotoSearchResultDomainModel
import com.cmaina.photos.domain.models.users.ProfileImageDomainModel
import com.cmaina.photos.domain.models.users.User

/** Maps DTOs from data layer to domain layer
 */
internal fun PhotoListItem.toDomain() = Photo(
    blurHash = blurHash ?: "",
    description = description ?: "",
    id = id,
    likedByUser = likedByUser ?: false,
    likes = likes ?: 0,
    photoUrls = urls!!.toDomain(),
    user = user,
)

internal fun PhotoStatistics.toDomain() = DomainPhotoStatistics(
    id = id,
    domainPhotoStatLikes = likes.toDomain(),
    domainPhotoStatDownloads = downloads.toDomain(),
    domainPhotoStatsViews = views.toDomain()
)

internal fun Likes.toDomain() = DomainPhotoStatLikes(
    total = total
)

internal fun Downloads.toDomain() =
    DomainPhotoStatDownloads(total = total)

internal fun Views.toDomain() =
    DomainPhotoStatsViews(total = total)

internal fun UserProfileImage.toDomain() = DomainUserProfileImage(
    large, medium, small
)

internal fun Social.toDomain() = DomainUserSocial(
    instagramUsername = instagramUsername,
    portfolioUrl = portfolioUrl,
    twitterUsername = twitterUsername
)

internal fun Urls.toDomain() = PhotoUrls(
    full = full,
    raw = raw,
    regular = regular,
    small = small,
    smallS3 = small_s3,
    thumb = thumb
)

internal fun ProfileImage.toDomain() = DomainProfileImage(
    large = large,
    medium = medium,
    small = small
)

internal fun com.cmaina.photos.data.network.models.users.ProfileImage.toDomain() =
    ProfileImageDomainModel(large, medium, small)

internal fun PhotoSearchResultDto.toDomain() = PhotoSearchResultDomainModel(
    searchedPhotoDomainModels = results.map { it.toDomain() },
    total = total,
    totalPages = total_pages
)

internal fun SearchedPhotoDto.toDomain() = Photo(
    blurHash = blurHash,
    description = description,
    id = id,
    likedByUser = likedByUser,
    likes = likes,
    photoUrls = urls.toDomain(),
    user = this.user
)

internal fun AuthRemoteResponse.toDomain() = AuthDomainResponse(
    accessToken = accessToken,
    createdAt = createdAt,
    scope = scope,
    tokenType = tokenType,
    refreshToken = refreshToken
)
