package com.cmaina.photos.presentation.utils

import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems

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
) { items(count = items.itemCount) { index -> items[index]?.let { itemContent(it) } } }