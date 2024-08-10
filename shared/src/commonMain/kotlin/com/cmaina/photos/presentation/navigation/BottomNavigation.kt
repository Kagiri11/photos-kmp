package com.cmaina.photos.presentation.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.cmaina.photos.presentation.utils.navigateTopScreens

val TopLevelDestinations = listOf(
    PhotosScreen.Home,
    PhotosScreen.Favorites,
    PhotosScreen.Settings,
)

@Composable
fun BottomNav(navHostController: NavHostController) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry?.destination

    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        TopLevelDestinations.forEach { screen ->
            AddBottomNavItem(
                screen = screen,
                currentScreen = currentScreen,
                navController = navHostController,
            )
        }
    }
}

@Composable
fun RowScope.AddBottomNavItem(
    screen: PhotosScreen,
    currentScreen: NavDestination?,
    navController: NavHostController,
) {
    val isSelected = currentScreen?.hierarchy?.any { it.route == screen.route } == true
    val color =
        if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primaryVariant
    BottomNavigationItem(
        selected = isSelected,
        onClick = {
            navController.navigateTopScreens(screen)
        },
        label = {
            Text(
                text = screen.name,
                style = TextStyle(color = color)
            )
        },
        alwaysShowLabel = true,
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Bottom nav Icon",
                tint = color
            )
        },
    )
}