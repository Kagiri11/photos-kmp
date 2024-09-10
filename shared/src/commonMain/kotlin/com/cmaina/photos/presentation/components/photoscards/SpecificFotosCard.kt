package com.cmaina.photos.presentation.components.photoscards

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.cmaina.photos.presentation.utils.ClickAction

@Composable
fun RowScope.PhotosPager(
    images: List<String>,
    pageInIteration: (Int) -> Unit,
    onPageSwapped: (String) -> Unit,
    action: ClickAction
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        images.size
    }

    LaunchedEffect(action) {
        when (action) {
            ClickAction.Next -> pagerState.scrollToPage(pagerState.currentPage + 1)
            ClickAction.Prev -> pagerState.scrollToPage(pagerState.currentPage - 1)
            ClickAction.None -> {}
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.weight(0.8f)
    ) { page ->
        pageInIteration(pagerState.currentPage)
        onPageSwapped(images[page])
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(2)
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                model = images[page],
                contentDescription = "related image"
            )
        }
    }
}
