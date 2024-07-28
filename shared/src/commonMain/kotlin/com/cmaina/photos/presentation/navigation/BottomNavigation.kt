package com.cmaina.photos.presentation.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
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
    BottomNavigationItem(
        selected = isSelected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.startDestinationRoute!!)
                launchSingleTop = true
            }
        },
        label = {
            Text(
                text = screen.name,
                style = TextStyle(color = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primary)
            )
        },
        alwaysShowLabel = isSelected,
        icon = {
            // TODO: Add icon to bottom nav screens
            /*Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = screen.label,
                tint = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onPrimary
            )*/
        },
    )
}