package com.cmaina.photos.presentation.screens.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.domain.repositories.PhotosRepository
import com.cmaina.photos.domain.repositories.UsersRepository
import com.cmaina.photos.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val usersRepository: UsersRepository,
    private val photosRepository: PhotosRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Loading)
    val uiState: StateFlow<UserUiState> get() = _uiState

    fun fetchUser(username: String) = viewModelScope.launch {
        usersRepository.fetchUser(username = username).collect { networkResult ->
            when (networkResult) {
                is Result.Success -> {
                    with(networkResult.data) {
                        val details = UserUiDetails(
                            numberOfPhotosByUser = totalPhotos,
                            userImageUrl = profileImage.large ?: "",
                            followersCount = followersCount,
                            followingCount = followingCount,
                            userPhotos = photosRepository.fetchUserPhotos(username),
                            userName = this.name
                        )
                        _uiState.value = UserUiState.Success(uiDetails = details)
                    }
                }

                is Result.Error -> {
                    _uiState.value = UserUiState.Error(errorMessage = networkResult.errorDetails)
                }
            }
        }
    }
}

sealed interface UserUiState {

    data class Success(val uiDetails: UserUiDetails) : UserUiState

    object Loading : UserUiState

    data class Error(val errorMessage: String) : UserUiState
}

data class UserUiDetails(
    val userPhotos: Flow<PagingData<Photo>>,
    val userImageUrl: String,
    val numberOfPhotosByUser: Int,
    val followersCount: Int,
    val followingCount: Int,
    val userName: String
)
