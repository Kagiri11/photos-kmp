package com.cmaina.photos.presentation.utils

import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.request.crossfade
import coil3.util.DebugLogger
import kotlinx.serialization.Serializable

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

inline fun <T : Any> LazyGridScope.items(
    items: LazyPagingItems<T>,
    crossinline itemContent: @Composable LazyGridItemScope.(value: T) -> Unit
) {
    items(count = items.itemCount) { index -> items[index]?.let { itemContent(it) } }
}

fun getAsyncImageLoader(context: PlatformContext) =
    ImageLoader.Builder(context).crossfade(true).logger(DebugLogger()).build()

object PreferenceKeys {
    const val AppTheme = "app_theme"
    const val AppLanguage = "app_language"
}

@Serializable
data class Language(val name: String, val initials: String)

val LanguageList = listOf(
    Language("English", "en"),
    Language("Italian", "it"),
    Language("German", "de")
)