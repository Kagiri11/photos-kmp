package com.cmaina.photos.presentation.screens.photodetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmaina.photos.domain.models.users.User
import com.cmaina.photos.domain.repositories.AuthRepository
import com.cmaina.photos.domain.repositories.PhotosRepository
import com.cmaina.photos.domain.utils.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PhotoDetailsViewModel(
    private val photosRepository: PhotosRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PhotoDetailsUiState>(PhotoDetailsUiState.Loading)
    val uiState: StateFlow<PhotoDetailsUiState> get() = _uiState

    fun fetchPhoto(photoId: String) {
        viewModelScope.launch {
            when (val result = photosRepository.getSpecificPhoto(photoId = photoId)) {
                is Result.Success -> {
                    with(result.data) {
                        val images =
                            this.relatedCollections.collections.flatMap { it.previewPhotos.map { it.urls.regular } }
                                .toMutableList()
                        images.add(this.urls.regular)
                        val details = Details(
                            userName = user.name,
                            userPhotoImageUrl = user.userProfileImage.medium,
                            numberOfLikes = likes,
                            relatedImages = images.reversed(),
                            photoIsLikedByUser = false
                        )
                        _uiState.value =
                            PhotoDetailsUiState.Success(details = details)
                    }
                }

                is Result.Error -> {
                    _uiState.value =
                        PhotoDetailsUiState.Error(errorMessage = result.errorDetails)
                }
            }
        }
    }
}


sealed interface PhotoDetailsUiState {

    data class Success(val details: Details) : PhotoDetailsUiState

    object Loading : PhotoDetailsUiState

    data class Error(val errorMessage: String) : PhotoDetailsUiState
}

data class Details(
    val userName: String,
    val userPhotoImageUrl: String,
    val numberOfLikes: Int,
    val relatedImages: List<String>,
    val photoIsLikedByUser: Boolean,
    val user: User? = null
)
