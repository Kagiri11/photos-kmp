package com.cmaina.photos.presentation.screens.favorites

import com.cmaina.photos.domain.models.photos.Photo

data class FavoritesUiState(
    val favorites: List<Photo> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)