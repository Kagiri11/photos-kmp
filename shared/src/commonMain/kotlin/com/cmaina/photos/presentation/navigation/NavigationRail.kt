package com.cmaina.photos.presentation.navigation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.cmaina.photos.presentation.utils.navigateTopScreens
import org.jetbrains.compose.resources.stringResource

@Composable
fun NavigationRail(navHostController: NavHostController) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()

    androidx.compose.material3.NavigationRail(
        modifier = Modifier.fillMaxHeight().wrapContentWidth(),
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        TopLevelDestinations.forEach { screen ->
            val isSelected = navBackStackEntry?.destination?.route == screen.route

            NavigationRailItem(
                selected = isSelected,
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedTextColor = MaterialTheme.colorScheme.secondary,
                ),
                label = {
                    Text(
                        text = stringResource(screen.label),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                },
                onClick = { navHostController.navigateTopScreens(screen) },
                icon = {
                    Icon(
                        modifier = if (isSelected) Modifier.size(30.dp)
                            .animateContentSize() else Modifier.size(25.dp),
                        imageVector = screen.icon,
                        contentDescription = "Bottom nav Icon"
                    )
                }
            )
        }
    }
}