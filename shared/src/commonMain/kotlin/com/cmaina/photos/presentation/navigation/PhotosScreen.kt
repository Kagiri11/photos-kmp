package com.cmaina.photos.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class PhotosScreen(
    val route: String,
    val icon: ImageVector = Icons.Rounded.Home,
) {
    Home("home"),
    PhotoDetails("photo_details"),
    Settings("settings", Icons.Rounded.Settings),
    User("user"),
    Favorites("favorites", Icons.Rounded.Favorite)
}