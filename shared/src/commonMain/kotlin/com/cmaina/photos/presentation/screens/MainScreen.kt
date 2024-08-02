package com.cmaina.photos.presentation.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cmaina.photos.presentation.navigation.BottomNav
import com.cmaina.photos.presentation.navigation.NavigationRail
import com.cmaina.photos.presentation.navigation.PhotosApp
import com.cmaina.photos.presentation.navigation.TopLevelDestinations
import com.cmaina.photos.presentation.ui.theme.PhotosTheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MainScreen() {
    val windowSize = calculateWindowSizeClass()
    val windowIsCompacted = windowSize.widthSizeClass < WindowWidthSizeClass.Medium
    val navController: NavHostController = rememberNavController()

    PhotosTheme {
        when (windowIsCompacted) {
            true -> {
                Scaffold(
                    bottomBar = { BottomNav(navController) },
                    content = { PhotosApp(navController) }
                )
            }

            false -> {
                Row {
                    NavigationRail(navController)
                    PhotosApp(navController)
                }
            }
        }
    }
}