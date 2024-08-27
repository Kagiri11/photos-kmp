package com.cmaina.photos.presentation.components.photoscards

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch

enum class ClickAction {
    Prev, Next, None
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotosPager(
    images: List<String>,
    pageInIteration: (Int) -> Unit,
    onPageSwapped: (String) -> Unit,
    action: ClickAction
) {
    println("Recomposition due to action: $action")
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
        modifier = Modifier.fillMaxWidth(0.90f).fillMaxHeight(0.95f)
    ) { page ->
        pageInIteration(pagerState.currentPage)
        onPageSwapped(images[page])
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(2)
        ) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = images[page],
                contentDescription = "related image"
            )
        }
    }
}
