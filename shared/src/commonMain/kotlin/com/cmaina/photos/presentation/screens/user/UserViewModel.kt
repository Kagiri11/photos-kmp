package com.cmaina.photos.presentation.screens.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.cmaina.photos.data.network.utils.Constants
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.domain.repositories.PhotosRepository
import com.cmaina.photos.domain.repositories.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/** UI state for the Home screen
 *  Fetches user details from [usersRepository]
 */
class UserViewModel(
    private val usersRepository: UsersRepository,
    private val photosRepository: PhotosRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Loading)
    val uiState: StateFlow<UserUiState> get() = _uiState

    fun fetchUser(username: String) = viewModelScope.launch {
        usersRepository.getUser(username = username).collect { networkResult ->
            networkResult
                .onSuccess { user ->
                    val details = UserUiDetails(
                        numberOfPhotosByUser = user.totalPhotos,
                        userImageUrl = user.profileImage.large.orEmpty(),
                        followersCount = user.followersCount,
                        followingCount = user.followingCount,
                        userPhotos = photosRepository.getUserPhotos(username),
                        userName = user.name
                    )
                    _uiState.value = UserUiState.Success(uiDetails = details)
                }
                .onFailure {
                    _uiState.value =
                        UserUiState.Error(errorMessage = it.message ?: Constants.UNKNOWN_ERROR)
                }
        }
    }
}

sealed interface UserUiState {
    data class Success(val uiDetails: UserUiDetails) : UserUiState
    data class Error(val errorMessage: String) : UserUiState
    data object Loading : UserUiState
}

data class UserUiDetails(
    val userPhotos: Flow<PagingData<Photo>>,
    val numberOfPhotosByUser: Int,
    val userImageUrl: String,
    val followersCount: Int,
    val followingCount: Int,
    val userName: String
)
