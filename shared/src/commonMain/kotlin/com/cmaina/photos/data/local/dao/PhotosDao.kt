package com.cmaina.photos.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.cmaina.photos.domain.models.photos.FavoritePhoto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritePhotosDao {
    @Insert
    suspend fun insert(photo: FavoritePhoto)

    @Query("SELECT * FROM favorite_photos")
    fun getAllPhotos(): Flow<List<FavoritePhoto>>

    @Query("DELETE FROM favorite_photos WHERE id = :photoId")
    suspend fun deletePhoto(photoId: String)
}