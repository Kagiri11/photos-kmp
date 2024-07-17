package com.cmaina.photos.domain.repositories

import androidx.paging.PagingData
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.domain.models.photostats.DomainPhotoStatistics
import com.cmaina.photos.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    suspend fun fetchPhotos(): Result<Flow<PagingData<Photo>>>

    suspend fun getRandomPhoto(): Result<Photo>

    suspend fun getSpecificPhoto(photoId: String): Result<Photo>

    suspend fun fetchUserPhotos(username: String): Flow<androidx.paging.PagingData<com.cmaina.photos.domain.models.photos.Photo>>

    suspend fun getPhotoStatistics(photoId: String): Flow<Result<DomainPhotoStatistics>>

    suspend fun searchPhoto(searchString: String): Flow<PagingData<com.cmaina.photos.domain.models.photos.Photo>>

    suspend fun likePhoto(id: String): Result<Photo>
}