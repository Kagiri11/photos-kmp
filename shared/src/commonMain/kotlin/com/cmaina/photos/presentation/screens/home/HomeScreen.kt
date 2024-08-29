package com.cmaina.photos.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.presentation.components.photoscards.PhotoCardItem
import com.cmaina.photos.presentation.utils.items
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.home_screen_title

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel(),
    onPhotoClicked: (Photo) -> Unit
) {
    val uiState = homeViewModel.uiState.collectAsState().value
    val lazyGridState = rememberLazyGridState()

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = stringResource(Res.string.home_screen_title),
            modifier = Modifier.padding(start = 10.dp, top = 5.dp),
            style = TextStyle(
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
        )

        when (uiState) {
            is HomeUiState.Loading -> {}
            is HomeUiState.Error -> {}

            is HomeUiState.Success -> {
                val photos = uiState.pagedPhotos.collectAsLazyPagingItems()
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxWidth(),
                    columns = GridCells.Adaptive(150.dp),
                    contentPadding = PaddingValues(1.dp),
                    state = lazyGridState
                ) {
                    items(
                        items = photos
                    ) { photo ->
                        PhotoCardItem(
                            imageUrl = photo.photoUrls.small,
                            contentDescription = photo.description,
                        ) {
                            onPhotoClicked(photo)
                        }
                    }
                }
            }
        }
    }
}
