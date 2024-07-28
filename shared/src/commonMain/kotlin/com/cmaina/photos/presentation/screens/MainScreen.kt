package com.cmaina.photos.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cmaina.photos.presentation.navigation.PhotosApp
import com.cmaina.photos.presentation.ui.theme.PhotosTheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MainScreen() {
    val windowSize = calculateWindowSizeClass()
    val windowIsCompacted = windowSize.widthSizeClass < WindowWidthSizeClass.Medium
    PhotosTheme {
        when (windowIsCompacted) {
            true -> {
                Scaffold(
                    bottomBar = {
                        BottomNavigation(
                            modifier = Modifier.fillMaxWidth().height(30.dp)
                        ) { }
                    },
                    content = { PhotosApp() })
            }

            false -> {
                Row {
                    Column(modifier = Modifier.width(20.dp).fillMaxHeight()) {}
                    PhotosApp()
                }
            }
        }
    }
}