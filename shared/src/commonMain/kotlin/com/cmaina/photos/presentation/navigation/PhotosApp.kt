package com.cmaina.photos.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cmaina.photos.presentation.screens.home.HomeScreen
import com.cmaina.photos.presentation.screens.photodetails.PhotoDetailsScreen
import com.cmaina.photos.presentation.screens.settings.SettingsScreen
import com.cmaina.photos.presentation.screens.user.UserScreen

@Composable
fun PhotosApp(
    navController: NavHostController = rememberNavController(),
    startDestination: String = PhotosScreen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = PhotosScreen.Home.route) {
            HomeScreen(
                onPhotoClicked = {}
            )
        }

        composable(route = PhotosScreen.PhotoDetails.route) {
            PhotoDetailsScreen(
                onInitialLoadEvent = {},
                onUserSectionClickedEvent = {},
                onImageLikedEvent = {},
                onDialogDismissedEvent = {},
                onPageSwappedEvent = {},
                messageIsPresent = true,
                onUserRequestsAuthenticationEvent = {}
            )
        }

        composable(route = PhotosScreen.Settings.route) {
            SettingsScreen()
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