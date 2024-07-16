package com.cmaina.photos.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.cmaina.photos.presentation.components.photoscards.PhotoCardItem
import com.cmaina.photos.presentation.components.photostext.FotosTitleText
import com.cmaina.photos.presentation.utils.lazyItems
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel(),
    onPhotoClicked: (String) -> Unit
) {
    val uiState = homeViewModel.uiState.collectAsState().value
    val lazyStaggeredGridState = rememberLazyStaggeredGridState()

    Column(modifier = Modifier.fillMaxSize()) {
        FotosTitleText(
            text = "Explore",
            textColor = MaterialTheme.colors.onPrimary,
            modifier = Modifier
        )

        when (uiState) {
            is HomeUiState.Loading -> {}
            is HomeUiState.Error -> {}
            is HomeUiState.Success -> {
                val photos = uiState.pagedPhotos.collectAsLazyPagingItems()
                LazyVerticalStaggeredGrid(
                    modifier = Modifier.fillMaxWidth(),
                    columns = StaggeredGridCells.Fixed(2),
                    contentPadding = PaddingValues(1.dp),
                    state = lazyStaggeredGridState
                ) {
                    lazyItems(photos) { pic ->
                        PhotoCardItem(
                            blurHash = pic?.blurHash ?: "",
                            imageUrl = pic?.photoUrls?.small ?: "",
                            contentDescription = pic?.description ?: "",
                            onPhotoClicked = {
                                onPhotoClicked(pic?.id!!)
                            }
                        )
                    }
                }
            }
        }
    }
}
