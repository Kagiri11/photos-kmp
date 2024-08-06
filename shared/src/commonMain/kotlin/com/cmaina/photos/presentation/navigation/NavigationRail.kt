package com.cmaina.photos.presentation.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.cmaina.photos.presentation.ui.theme.FotosGreyShadeThreeLightTheme

@Composable
fun NavigationRail(navHostController: NavHostController) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()

    NavigationRail(
        modifier = Modifier.fillMaxHeight(),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        TopLevelDestinations.forEach { screen ->
            val isSelected = navBackStackEntry?.destination?.route == screen.route
            NavigationRailItem(
                selected = isSelected,
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = "Bottom nav Icon",
                        tint = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primaryVariant
                    )
                },
                onClick = {
                    // TODO: Make this a shared code logic
                    navHostController.navigate(screen.route) {
                        popUpTo(navHostController.graph.startDestinationRoute!!)
                        launchSingleTop = true
                    }
                },
                label = {
                    Text(
                        text = screen.name,
                        color = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primaryVariant
                    )
                }
            )
        }
    }
}