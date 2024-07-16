package com.cmaina.photos.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.domain.repositories.PhotosRepository
import com.cmaina.photos.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val photosRepository: PhotosRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> get() = _uiState

    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        viewModelScope.launch {
            _uiState.value = when (val result = photosRepository.fetchPhotos()) {
                is Result.Success -> HomeUiState.Success(pagedPhotos = result.data)
                is Result.Error -> HomeUiState.Error(errorMessage = result.errorDetails)
            }
        }
    }
}

sealed interface HomeUiState{

    data class Success(val pagedPhotos: Flow<PagingData<Photo>>): HomeUiState

    object Loading: HomeUiState

    data class Error(val errorMessage: String): HomeUiState
}
