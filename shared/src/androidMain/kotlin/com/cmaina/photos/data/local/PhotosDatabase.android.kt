package com.cmaina.photos.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<PhotosDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("photos.db")
    return Room.databaseBuilder<PhotosDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}