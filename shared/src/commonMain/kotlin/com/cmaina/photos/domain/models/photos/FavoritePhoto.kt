package com.cmaina.photos.domain.models.photos

import androidx.room.Entity

@Entity(tableName = "favorite_photos")
data class FavoritePhoto(
    val id: String,
    val imageUrl: String
)