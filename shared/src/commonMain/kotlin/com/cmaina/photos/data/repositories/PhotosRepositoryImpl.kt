package com.cmaina.photos.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cmaina.photos.data.local.dao.FavoritePhotosDao
import com.cmaina.photos.data.network.models.photos.PhotoListItem
import com.cmaina.photos.data.network.models.photostats.PhotoStatistics
import com.cmaina.photos.data.mappers.toDomain
import com.cmaina.photos.data.network.InOut
import com.cmaina.photos.data.network.models.specificphoto.SpecificPhoto
import com.cmaina.photos.data.network.sources.PhotosRemoteSource
import com.cmaina.photos.data.network.sources.UsersRemoteSource
import com.cmaina.photos.data.repositories.paging.PhotosPagingSource
import com.cmaina.photos.data.repositories.paging.SearchedPhotosPagingSource
import com.cmaina.photos.data.repositories.paging.UserPhotosPagingSource
import com.cmaina.photos.domain.models.photos.FavoritePhoto
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.domain.models.photostats.DomainPhotoStatistics
import com.cmaina.photos.domain.repositories.PhotosRepository
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PhotosRepositoryImpl(
    private val photosRemoteSource: PhotosRemoteSource,
    private val usersRemoteSource: UsersRemoteSource,
    private val favoritePhotosDao: FavoritePhotosDao
) : PhotosRepository {

    override suspend fun fetchFavoritePhotos() = favoritePhotosDao.getAllPhotos()

    override suspend fun fetchPhotos(): Result<Flow<PagingData<Photo>>> {
        val pagingConfig = PagingConfig(pageSize = 30)
        val photosPager = Pager(pagingConfig) {
            PhotosPagingSource(photosRemoteSource = photosRemoteSource)
        }.flow
        return Result.success(photosPager)
    }

    override suspend fun getRandomPhoto(): Result<Photo> {
        val call = photosRemoteSource.fetchRandomPhoto()
        return InOut<PhotoListItem, Photo>(
            call.body()
        ).apiCall(
            response = call,
            mapper = { it.toDomain() }
        )
    }


    override suspend fun getSpecificPhoto(photoId: String): Result<SpecificPhoto> {
        val call = photosRemoteSource.fetchPhoto(photoId)
        return InOut<SpecificPhoto, SpecificPhoto>(
            call.body()
        ).apiCall(
            response = call,
            mapper = {
                it
            }
        )
    }

    override suspend fun fetchUserPhotos(username: String): Flow<PagingData<Photo>> {
        val pagingConfig = PagingConfig(pageSize = 30)
        val userPhotosPager = Pager(pagingConfig) {
            UserPhotosPagingSource(usersRemoteSource = usersRemoteSource, username = username)
        }.flow
        return userPhotosPager
    }

    override suspend fun getPhotoStatistics(photoId: String): Flow<Result<DomainPhotoStatistics>> {
        val call = photosRemoteSource.fetchPhotoStatistics(photoId)
        return flowOf(
            InOut<PhotoStatistics, DomainPhotoStatistics>(call.body())
                .apiCall(
                    response = call,
                ) {
                    it.toDomain()
                }
        )
    }

    override suspend fun searchPhoto(searchString: String): Flow<PagingData<Photo>> {
        val pagingConfig = PagingConfig(pageSize = 30)
        val searchedPhotosPager = Pager(pagingConfig) {
            SearchedPhotosPagingSource(
                photosRemoteSource = photosRemoteSource,
                searchString = searchString
            )
        }.flow
        return searchedPhotosPager
    }

    override suspend fun savePhoto(photo: FavoritePhoto) {
        favoritePhotosDao.insert(photo)
    }

    override suspend fun unSavePhoto(photoId: String) {
        favoritePhotosDao.deletePhoto(photoId)
    }
}
