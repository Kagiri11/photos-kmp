package com.cmaina.photos.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.cmaina.photos.data.local.dao.FavoritePhotosDao
import com.cmaina.photos.domain.models.photos.FavoritePhoto
import kotlinx.coroutines.Dispatchers

@Database(entities = [FavoritePhoto::class], version = 1, exportSchema = false)
abstract class PhotosDatabase : RoomDatabase() {
    abstract fun favoritePhotosDao(): FavoritePhotosDao
}

fun getPhotosDatabase(
    builder: RoomDatabase.Builder<PhotosDatabase>
): PhotosDatabase {
    return builder
        .fallbackToDestructiveMigrationOnDowngrade(false)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

