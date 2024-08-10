package com.cmaina.photos.presentation.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cmaina.photos.presentation.navigation.BottomNav
import com.cmaina.photos.presentation.navigation.NavigationRail
import com.cmaina.photos.presentation.navigation.PhotosApp
import com.cmaina.photos.presentation.ui.theme.PhotosTheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MainScreen() {
    val windowSize = calculateWindowSizeClass()
    val navController: NavHostController = rememberNavController()

    PhotosTheme {
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
                true -> {
                    Scaffold(
                        bottomBar = { BottomNav(navController) },
                        content = {
                            PhotosApp(
                                navController = navController
                            )
                        }
                    )
                }

                false -> {
                    Surface {
                        Row {
                            NavigationRail(navController, modifier = Modifier.weight(0.1f, fill = true))
                            Spacer(modifier = Modifier.width(10.dp))
                            Card(
                                modifier = Modifier.fillMaxSize().weight(0.8f),
                                shape = RoundedCornerShape(0),
                                elevation = 10.dp
                            ) {
                                PhotosApp(navController)
                            }
                        }
                    }
                }
            }
        }
    }
}