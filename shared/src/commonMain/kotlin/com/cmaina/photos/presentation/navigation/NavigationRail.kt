package com.cmaina.photos.presentation.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavigationRail(
    navHostController: NavHostController
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()

    NavigationRail(
        modifier = Modifier.fillMaxHeight()
    ) {
        TopLevelDestinations.forEach { screen ->
            val isSelected = navBackStackEntry?.destination?.route == screen.route
            NavigationRailItem(
                selected = isSelected,
                icon = {},
                onClick = {
                    navHostController.navigate(screen.route) {
                        popUpTo(navHostController.graph.startDestinationRoute!!)
                        launchSingleTop = true
                    }
                },
                label = {
                    Text(text = screen.name)
                }
            )
        }
    }
}