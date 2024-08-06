package com.cmaina.photos.presentation.utils

import androidx.navigation.NavHostController
import com.cmaina.photos.presentation.navigation.PhotosScreen

fun NavHostController.navigateTopScreens(screen: PhotosScreen) {
    this.navigate(screen.route) {
        popUpTo(this@navigateTopScreens.graph.startDestinationRoute!!)
        launchSingleTop = true
    }
}