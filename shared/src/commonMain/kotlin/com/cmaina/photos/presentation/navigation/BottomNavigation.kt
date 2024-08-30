package com.cmaina.photos.presentation.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.cmaina.photos.presentation.utils.navigateTopScreens
import org.jetbrains.compose.resources.stringResource

val TopLevelDestinations = listOf(
    PhotosScreen.Home,
    PhotosScreen.Favorites,
    PhotosScreen.Settings,
)

@Composable
fun BottomNav(navHostController: NavHostController) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry?.destination

    NavigationBar(modifier = Modifier.fillMaxWidth()) {
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

    NavigationBarItem(
        selected = isSelected,
        onClick = { navController.navigateTopScreens(screen) },
        icon = { Icon(imageVector = screen.icon, contentDescription = "Bottom nav Icon") },
        label = {
            if (!isSelected)
                Text(text = stringResource(screen.label))
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
            unselectedIconColor = MaterialTheme.colorScheme.secondary,
            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
            unselectedTextColor = MaterialTheme.colorScheme.secondary,
        )
    )
}