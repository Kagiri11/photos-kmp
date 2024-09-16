package com.cmaina.photos.presentation.utils

import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.paging.compose.LazyPagingItems
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.request.crossfade
import coil3.util.DebugLogger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.StringResource
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.language_de
import photos.shared.generated.resources.language_en
import photos.shared.generated.resources.language_it

inline fun <T : Any> LazyStaggeredGridScope.lazyItems(
    items: LazyPagingItems<T>,
    crossinline itemContent: @Composable LazyStaggeredGridItemScope.(value: T?) -> Unit
) {
    items(
        count = items.itemCount
    ) { index ->
        itemContent(items[index])
    }
}

enum class ClickAction {
    Prev, Next, None
}

inline fun <T : Any> LazyGridScope.items(
    items: LazyPagingItems<T>,
    crossinline itemContent: @Composable LazyGridItemScope.(value: T) -> Unit
) {
    items(count = items.itemCount) { index -> items[index]?.let { itemContent(it) } }
}

object PreferenceKeys {
    const val AppTheme = "app_theme"
    const val AppLanguage = "app_language"
}

@Composable
fun <T : Any> LazyPagingItems<T>.rememberLazyGridState(): LazyGridState {
    return when (itemCount) {
        0 -> remember(this) { LazyGridState(0, 0) }
        else -> androidx.compose.foundation.lazy.grid.rememberLazyGridState()
    }
}

fun lazyListSaver(): Saver<MutableState<LazyGridState>, *> = listSaver(
    save = { listOf(it.value.firstVisibleItemIndex, it.value.firstVisibleItemScrollOffset) },
    restore = {
        mutableStateOf(
            LazyGridState(
                firstVisibleItemIndex = it[0],
                firstVisibleItemScrollOffset = it[1]
            )
        )
    }
)