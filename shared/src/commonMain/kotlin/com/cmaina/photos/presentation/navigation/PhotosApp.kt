package com.cmaina.photos.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cmaina.photos.presentation.screens.favorites.FavoritesScreen
import com.cmaina.photos.presentation.screens.home.HomeScreen
import com.cmaina.photos.presentation.screens.photodetails.PhotoDetailsScreen
import com.cmaina.photos.presentation.screens.settings.SettingsScreen
import com.cmaina.photos.presentation.screens.user.UserScreen

@Composable
fun PhotosApp(
    navController: NavHostController,
    startDestination: String = PhotosScreen.Home.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = PhotosScreen.Home.route) {
            HomeScreen(
                onPhotoClicked = {
                    navController.navigate(PhotosScreen.PhotoDetails.route + "/${it.id}")
                }
            )
        }

        composable(
            route = PhotosScreen.PhotoDetails.route + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val photoId = backStackEntry.arguments?.getString("id") ?: return@composable
            PhotoDetailsScreen(
                photoId = photoId,
                onUserSectionClickedEvent = {},
                onImageLikedEvent = {},
                onPageSwappedEvent = {},
                onBackBtnClicked = { navController.navigateUp() }
            )
        }

        composable(route = PhotosScreen.Settings.route) {
            SettingsScreen()
        }

        composable(route = PhotosScreen.Favorites.route) {
            FavoritesScreen()
        }

        composable(route = PhotosScreen.User.route) {
            UserScreen(
                onScreenLoad = {},
                onBackPressed = {},
                onUserPhotoClicked = {}
            )
        }
    }
}
