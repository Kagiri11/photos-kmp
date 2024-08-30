package com.cmaina.photos.presentation.screens.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.cmaina.photos.presentation.components.photoscards.PhotoCardItem
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun FavoritesScreen(
    favoritesViewModel: FavoritesViewModel = koinViewModel()
) {
    val uiState = favoritesViewModel.uiState.collectAsState().value
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(uiState.favoritePhotos) { favoritePhoto ->
                PhotoCardItem(
                    imageUrl = favoritePhoto.imageUrl,
                    contentDescription = "",
                    onPhotoClicked = {}
                )
            }
        }
    }
}