package com.cmaina.photos.presentation.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmaina.photos.presentation.components.settingscomponents.Setting
import com.cmaina.photos.presentation.components.settingscomponents.SettingItemDialog
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI


@OptIn(KoinExperimentalAPI::class)
@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel = koinViewModel()
) {
    val isAppDarkTheme = settingsViewModel.appTheme.collectAsState().value
    val isThemeDialogOpen = settingsViewModel.isThemeDialogOpen.collectAsState().value
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
    ) {
        Text(
            text = "Settings",
            modifier = Modifier,
            style = TextStyle(
                fontSize = 30.sp,
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold
            )
        )

        Column(
            modifier = Modifier
                .semantics { contentDescription = "setting column" }
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,

            ) {
            Setting(
                settingName = "Display",
                settingAttribute = "Theme",
                attributeValue = if (isAppDarkTheme) "Dark" else "Light",
                settingIcon = Icons.Default.DarkMode
            ) {
                settingsViewModel.changeDialogOpenState()
            }
            SettingItemDialog(
                openDialog = isThemeDialogOpen,
                isAppInDarkMode = isAppDarkTheme,
                settingsViewModel = settingsViewModel,
                {
                    settingsViewModel.changeAppTheme(false)
                },
                {
                    settingsViewModel.changeAppTheme(true)
                }
            )
        }
    }
}
