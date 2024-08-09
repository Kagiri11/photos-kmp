package com.cmaina.photos.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import com.cmaina.photos.presentation.components.photoscards.PhotoCardItem
import com.cmaina.photos.presentation.components.photostext.FotosTitleText
import com.cmaina.photos.presentation.utils.lazyItems
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel(), onPhotoClicked: (String) -> Unit
) {
    println("HomeScreenViewModel hash => ${homeViewModel.hashCode()}")
    val uiState = homeViewModel.uiState.collectAsState().value
    val lazyStaggeredGridState = rememberLazyStaggeredGridState()
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Explore", style = TextStyle(
                fontSize = 30.sp,
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold
            )
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
                    lazyItems(photos) { photo ->
                        PhotoCardItem(blurHash = photo?.blurHash ?: "",
                            imageUrl = photo?.photoUrls?.small ?: "",
                            contentDescription = photo?.description ?: "",
                            onPhotoClicked = {
                                onPhotoClicked(photo?.id!!)
                            })
                    }
                }
            }
        }
    }

}
