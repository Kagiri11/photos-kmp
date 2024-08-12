package com.cmaina.photos.presentation.screens.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmaina.photos.domain.repositories.PhotosRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val photosRepository: PhotosRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> get() = _uiState

    init {
        fetchFavoritePhotos()
    }

    private fun fetchFavoritePhotos() = viewModelScope.launch {
        photosRepository.fetchFavoritePhotos().collect { photos ->
            _uiState.update { it.copy(favoritePhotos = photos) }
        }
    }

    fun unFavoritePhoto(photoId: String) = viewModelScope.launch {
        photosRepository.unSavePhoto(photoId)
    }
}