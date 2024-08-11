package com.cmaina.photos.domain.repositories

import androidx.paging.PagingData
import com.cmaina.photos.data.network.models.specificphoto.SpecificPhoto
import com.cmaina.photos.domain.models.photos.FavoritePhoto
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.domain.models.photostats.DomainPhotoStatistics
import com.cmaina.photos.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    suspend fun fetchPhotos(): Result<Flow<PagingData<Photo>>>

    suspend fun getRandomPhoto(): Result<Photo>

    suspend fun getSpecificPhoto(photoId: String): Result<SpecificPhoto>

    suspend fun fetchUserPhotos(username: String): Flow<androidx.paging.PagingData<Photo>>

    suspend fun getPhotoStatistics(photoId: String): Flow<Result<DomainPhotoStatistics>>

    suspend fun searchPhoto(searchString: String): Flow<PagingData<Photo>>

    suspend fun favoritePhoto(photo: FavoritePhoto): Result<Photo>

    suspend fun fetchFavoritePhotos(): Flow<List<FavoritePhoto>>
}