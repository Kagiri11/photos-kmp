package com.cmaina.photos.presentation.screens.photodetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmaina.photos.domain.models.specificphoto.PreviewPhoto
import com.cmaina.photos.domain.repositories.AuthRepository
import com.cmaina.photos.domain.repositories.PhotosRepository
import com.cmaina.photos.domain.utils.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhotoDetailsViewModel(
    private val photosRepository: PhotosRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PhotoDetailsUiState>(PhotoDetailsUiState.Loading)
    val uiState: StateFlow<PhotoDetailsUiState> get() = _uiState
    private val _userIsAuthenticated = MutableStateFlow<Boolean>(false)
    val userIsAuthenticated: StateFlow<Boolean> get() = _userIsAuthenticated

    private val _messageToUser = MutableStateFlow(false)
    val messageToUser = _messageToUser.asStateFlow()

    init {
        checkIfUserHasBeenAuthenticated()
    }

    fun checkIfPhotoHasBeenLiked(photoId: String) {
        viewModelScope.launch {
            when (val result = photosRepository.getSpecificPhoto(photoId = photoId)) {
                is Result.Success -> {
                    val details = (_uiState.value as PhotoDetailsUiState.Success)
                        .details.copy(photoIsLikedByUser = result.data.likedByUser)
                    _uiState.value = PhotoDetailsUiState.Success(details)
                }

                is Result.Error -> {
                    _uiState.value = PhotoDetailsUiState.Error(result.errorDetails)
                }
            }
        }
    }

    fun likePhoto(photoID: String) = viewModelScope.launch {
        photosRepository.likePhoto(photoID)
    }

    fun changeMessageStatus() {
        _messageToUser.value = !_messageToUser.value
    }

    fun fetchPhoto(photoId: String) {
        viewModelScope.launch {
            when (val result = photosRepository.getSpecificPhoto(photoId = photoId)) {
                is Result.Success -> {
                    with(result.data) {
                        val details = Details(
                            userName = user.userName,
                            userPhotoImageUrl = user.userPhotoImageUrl,
                            numberOfLikes = likes,
                            relatedImages = listOf("" to this.photoUrls.full),
                            photoIsLikedByUser = false,
                            photoImageUrl = this.photoUrls.full
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

    private fun checkIfUserHasBeenAuthenticated() = viewModelScope.launch {
        authRepository.checkIfUserHasBeenAuthenticated().collect {
            _userIsAuthenticated.value = it
        }
    }

    fun authenticateUser(authCode: String) = viewModelScope.launch {
        authRepository.authenticateUser(authCode = authCode)
    }
}

data class PhotoLikedState(val photoId: String?, val photoUrl: String?, val blurHash: String?)

fun PreviewPhoto.toPhotoLikedState() =
    PhotoLikedState(photoId = this.id, photoUrl = this.urls?.full, blurHash = this.blurHash)

sealed interface PhotoDetailsUiState {

    data class Success(val details: Details) : PhotoDetailsUiState

    object Loading : PhotoDetailsUiState

    data class Error(val errorMessage: String) : PhotoDetailsUiState
}

data class Details(
    val userName: String,
    val userPhotoImageUrl: String,
    val numberOfLikes: Int,
    val relatedImages: List<Pair<String, String>>,
    val photoImageUrl: String,
    val photoIsLikedByUser: Boolean
)
