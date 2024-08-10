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
import com.cmaina.photos.presentation.utils.navigateTopScreens

@Composable
fun NavigationRail(navHostController: NavHostController,modifier: Modifier) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()

    NavigationRail(
        modifier = modifier.fillMaxHeight(),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        TopLevelDestinations.forEach { screen ->
            val isSelected = navBackStackEntry?.destination?.route == screen.route
            val color =
                if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primaryVariant
            NavigationRailItem(
                selected = isSelected,
                onClick = { navHostController.navigateTopScreens(screen) },
                label = { Text(text = screen.name, color = color) },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = "Bottom nav Icon",
                        tint = color
                    )
                }
            )
        }
    }
}