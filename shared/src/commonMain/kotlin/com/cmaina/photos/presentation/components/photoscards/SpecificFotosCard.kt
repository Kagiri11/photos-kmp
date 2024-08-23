package com.cmaina.photos.presentation.components.photoscards

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotosPager(
    images: List<String>,
    pageInIteration: (Int) -> Unit,
    onPageSwapped: (String) -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        images.size
    }

    HorizontalPager(state = pagerState) { page ->
        pageInIteration(pagerState.currentPage)
        onPageSwapped(images[page])
        Card(
            modifier = Modifier
                .fillMaxHeight(0.95f)
                .fillMaxWidth(0.95f),
            shape = RoundedCornerShape(2)
        ) {
            AsyncImage(
                model = images[page],
                contentDescription = "related image"
            )
        }
    }
}
