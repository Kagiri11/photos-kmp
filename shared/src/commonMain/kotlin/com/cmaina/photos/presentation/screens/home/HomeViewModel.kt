package com.cmaina.photos.presentation.screens.home

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cmaina.photos.domain.models.photos.FavoritePhoto
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.domain.repositories.AppRepository
import com.cmaina.photos.domain.repositories.PhotosRepository
import com.cmaina.photos.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale

class HomeViewModel(
    private val photosRepository: PhotosRepository,
    private val appRepository: AppRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> get() = _uiState

    init {
        fetchAppLanguage()
        fetchPhotos()
    }

    private fun fetchPhotos() {
        _uiState.update { HomeUiState.Loading }
        viewModelScope.launch {
            _uiState.update {
                when (val result = photosRepository.fetchPhotos()) {
                    is Result.Success -> HomeUiState.Success(result.data.cachedIn(viewModelScope))
                    is Result.Error -> HomeUiState.Error(errorMessage = result.errorDetails)
                }
            }
        }
    }

    private fun fetchAppLanguage() = viewModelScope.launch {
        appRepository.fetchAppLanguage().collect { language ->
            Locale.setDefault(Locale(language.initials))
        }
    }

    fun favoritePhoto(photo: Photo) = viewModelScope.launch {
        photosRepository.savePhoto(FavoritePhoto(id = photo.id, imageUrl = photo.photoUrls.regular))
    }

}

sealed interface HomeUiState {

    data class Success(val pagedPhotos: Flow<PagingData<Photo>>) : HomeUiState

    data object Loading : HomeUiState

    data class Error(val errorMessage: String) : HomeUiState
}
