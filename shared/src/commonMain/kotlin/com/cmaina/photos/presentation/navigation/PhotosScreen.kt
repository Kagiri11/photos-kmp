package com.cmaina.photos.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.bottom_nav_favorites
import photos.shared.generated.resources.bottom_nav_home
import photos.shared.generated.resources.bottom_nav_settings
import photos.shared.generated.resources.navigate_back

enum class PhotosScreen(
    val route: String,
    val icon: ImageVector = Icons.Rounded.Home,
    val label: StringResource = Res.string.bottom_nav_home,
) {
    Home(route = "home"),
    PhotoDetails(route = "photo_details", icon = Icons.Rounded.ArrowBack, label = Res.string.navigate_back),
    Settings("settings", Icons.Rounded.Settings, label = Res.string.bottom_nav_settings),
    User("user"),
    Favorites("favorites", Icons.Rounded.Favorite, label = Res.string.bottom_nav_favorites)
}