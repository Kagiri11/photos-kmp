package com.cmaina.photos.presentation.screens.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> get() = _uiState

    fun fetchFavoritePhotos() = viewModelScope.launch {

    }

    fun unFavoritePhoto(id: String) = viewModelScope.launch {

    }
}