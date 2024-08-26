package com.cmaina.photos.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Text
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

    NavigationRail(
        modifier = Modifier.fillMaxHeight().wrapContentWidth(),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        TopLevelDestinations.forEach { screen ->
            val isSelected = navBackStackEntry?.destination?.route == screen.route

            NavigationRailItem(
                selectedContentColor = MaterialTheme.colors.onPrimary,
                unselectedContentColor = MaterialTheme.colors.primaryVariant,
                selected = isSelected,
                label = {
                    Text(text = stringResource(screen.label), overflow = TextOverflow.Ellipsis)
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