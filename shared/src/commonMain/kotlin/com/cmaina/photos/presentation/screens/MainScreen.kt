package com.cmaina.photos.presentation.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import com.cmaina.photos.presentation.navigation.BottomNav
import com.cmaina.photos.presentation.navigation.NavigationRail
import com.cmaina.photos.presentation.navigation.PhotosApp
import com.cmaina.photos.presentation.navigation.TopLevelDestinations
import com.cmaina.photos.presentation.screens.settings.SettingsViewModel
import com.cmaina.photos.presentation.ui.theme.PhotosTheme
import com.cmaina.photos.presentation.utils.getAsyncImageLoader
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(
    ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalCoilApi::class,
    KoinExperimentalAPI::class
)
@Composable
fun MainScreen(
    settingsViewModel: SettingsViewModel = koinViewModel()
) {
    val windowSize = calculateWindowSizeClass()
    val navController: NavHostController = rememberNavController()
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    val isTopLevelDestination = TopLevelDestinations.any { it.route == currentDestination?.route }
    val uiState by settingsViewModel.uiState.collectAsState()

    setSingletonImageLoaderFactory { context ->
        getAsyncImageLoader(context)
    }

    CompositionLocalProvider(LocalLayoutDirection provides uiState.layoutDirection) {
        PhotosTheme(uiState) {
            AnimatedContent(
                targetState = windowSize.widthSizeClass < WindowWidthSizeClass.Medium,
                label = "MainScreen",
                transitionSpec = {
                    fadeIn(
                        animationSpec = tween(3000)
                    ) togetherWith fadeOut(animationSpec = tween(3000))
                }
            ) { targetState ->
                when (targetState) {
                    true -> Scaffold(
                        bottomBar = { if (isTopLevelDestination) BottomNav(navController) },
                        content = {
                            PhotosApp(
                                modifier = Modifier.padding(it),
                                navController = navController
                            )
                        }
                    )

                    false -> Surface {
                        Row {
                            NavigationRail(navController)
                            Spacer(modifier = Modifier.width(10.dp))
                            Card(
                                modifier = Modifier.fillMaxSize(),
                                shape = RoundedCornerShape(0),
                                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                            ) {
                                PhotosApp(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}