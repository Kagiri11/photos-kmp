package com.cmaina.photos.presentation.screens.settings

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmaina.photos.domain.models.settings.AppTheme
import com.cmaina.photos.presentation.components.settingscomponents.Setting
import com.cmaina.photos.presentation.components.settingscomponents.SettingItemDialog
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI


@OptIn(KoinExperimentalAPI::class)
@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel = koinViewModel()
) {
    val uiState by settingsViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
    ) {
        Text(
            modifier = Modifier.padding(start = 10.dp, top = 5.dp),
            text = "Settings",
            style = TextStyle(
                fontSize = 30.sp,
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        Column(
            modifier = Modifier
                .semantics { contentDescription = "setting column" }
                .fillMaxWidth().padding(horizontal = 5.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            Text(
                text = "Display",
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Setting(
                settingAttribute = "Theme",
                attributeValue = when (uiState.appTheme) {
                    AppTheme.Dark -> "Dark"
                    AppTheme.Light -> "Light"
                    AppTheme.SystemDefault -> "System Default"
                },
                settingIcon = when (uiState.appTheme) {
                    AppTheme.Dark -> Icons.Default.DarkMode
                    AppTheme.Light -> Icons.Default.LightMode
                    AppTheme.SystemDefault -> if (isSystemInDarkTheme()) Icons.Default.DarkMode else Icons.Default.LightMode
                },
            ) {
                settingsViewModel.changeDialogOpenState()
            }

            Setting(
                settingAttribute = "Language",
                attributeValue = "English",
                settingIcon = Icons.Default.Language,
            ) {
                settingsViewModel.changeDialogOpenState()
            }
        }

        SettingItemDialog(
            openDialog = uiState.isThemeDialogOpen,
            appTheme = uiState.appTheme,
            settingsViewModel = settingsViewModel
        ) { theme ->
            settingsViewModel.changeAppTheme(theme)
            settingsViewModel.changeDialogOpenState()
        }
    }
}
