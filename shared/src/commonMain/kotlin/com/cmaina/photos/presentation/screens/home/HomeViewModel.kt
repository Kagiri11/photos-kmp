package com.cmaina.photos.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.domain.repositories.PhotosRepository
import com.cmaina.photos.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class HomeViewModel(
    private val photosRepository: PhotosRepository
) : ViewModel(), KoinComponent {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> get() = _uiState

    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        viewModelScope.launch {
            _uiState.update {
                when (val result = photosRepository.fetchPhotos()) {
                    is Result.Success -> HomeUiState.Success(result.data.cachedIn(viewModelScope))
                    is Result.Error -> HomeUiState.Error(errorMessage = result.errorDetails)
                }
            }
        }
    }
}

sealed interface HomeUiState {

    data class Success(val pagedPhotos: Flow<PagingData<Photo>>) : HomeUiState

    object Loading : HomeUiState

    data class Error(val errorMessage: String) : HomeUiState
}
