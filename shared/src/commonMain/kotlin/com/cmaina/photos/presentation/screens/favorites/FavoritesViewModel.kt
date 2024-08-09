package com.cmaina.photos.presentation.screens.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

    fun fetchFavoritePhotos() = viewModelScope.launch {

    }

    fun unFavoritePhoto(id: String) = viewModelScope.launch {

    }
}