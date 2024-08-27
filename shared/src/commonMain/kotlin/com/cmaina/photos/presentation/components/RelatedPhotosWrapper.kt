package com.cmaina.photos.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cmaina.photos.presentation.components.photoscards.PhotosPager
import com.cmaina.photos.presentation.utils.ClickAction
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun RelatedPhotosWrapper(
    images: List<String>,
    pageInIteration: (Int) -> Unit,
    onPageSwapped: (String) -> Unit
) {
    val windowSize = calculateWindowSizeClass()
    val isCompact = windowSize.widthSizeClass < WindowWidthSizeClass.Medium
    var page by remember { mutableStateOf(0) }
    var action by remember { mutableStateOf(ClickAction.None) }
    val isOnLastPage = page == images.lastIndex
    val isOnFirstPage = page == 0
    val scope = rememberCoroutineScope()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (!isCompact) {
            AnimatedContent(isOnFirstPage) {
                if (it) {
                    Spacer(modifier = Modifier.size(30.dp))
                } else {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp).clickable {
                            scope.launch {
                                action = ClickAction.Prev
                                delay(200)
                                action = ClickAction.None
                            }

                        }
                    )
                }
            }
        }

        PhotosPager(
            images = images,
            pageInIteration = {
                println("page in iteration: $it")
                page = it
                pageInIteration(it)
            },
            onPageSwapped = { onPageSwapped(it) },
            action = action
        )

        if (!isCompact) {
            AnimatedContent(isOnLastPage) {
                if (it) {
                    Spacer(modifier = Modifier.size(30.dp))
                } else {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp).clickable {
                            scope.launch {
                                action = ClickAction.Next
                                delay(200)
                                action = ClickAction.None
                            }
                        }
                    )
                }
            }
        }
    }
}