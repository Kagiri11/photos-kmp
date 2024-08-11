package com.cmaina.photos.presentation.screens.favorites

import com.cmaina.photos.domain.models.photos.FavoritePhoto

data class FavoritesUiState(
    val favorites: List<FavoritePhoto> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)