package com.cmaina.photos.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.presentation.components.photoscards.PhotoCardItem
import com.cmaina.photos.presentation.utils.items

@Composable
fun PhotosGrid(
    state: LazyGridState,
    photos: LazyPagingItems<Photo>,
    onPhotoClicked: (Photo) -> Unit
) {
    val lazyGridState = rememberLazyGridState()

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