package com.cmaina.photos.domain.models.photos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_photos")
data class FavoritePhoto(
    @PrimaryKey(autoGenerate = false)val id: String,
    val imageUrl: String
)