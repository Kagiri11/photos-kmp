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
import androidx.compose.runtime.Composable
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
import com.cmaina.photos.presentation.components.settingscomponents.LanguageSelectionDialog
import com.cmaina.photos.presentation.components.settingscomponents.Setting
import com.cmaina.photos.presentation.components.settingscomponents.SettingItemDialog
import com.cmaina.photos.presentation.utils.Language
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.display
import photos.shared.generated.resources.language
import photos.shared.generated.resources.language_en
import photos.shared.generated.resources.settings_screen_title
import photos.shared.generated.resources.theme
import photos.shared.generated.resources.theme_dark
import photos.shared.generated.resources.theme_light
import photos.shared.generated.resources.theme_sys_default

@OptIn(KoinExperimentalAPI::class)
@Composable
fun SettingsScreen(settingsViewModel: SettingsViewModel = koinViewModel()) {
    val uiState by settingsViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
    ) {
        Text(
            modifier = Modifier.padding(start = 10.dp, top = 5.dp),
            text = stringResource(Res.string.settings_screen_title),
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
                text = stringResource(Res.string.display),
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Setting(
                settingAttribute = stringResource(Res.string.theme),
                attributeValue = when (uiState.appTheme) {
                    AppTheme.Dark -> stringResource(Res.string.theme_dark)
                    AppTheme.Light -> stringResource(Res.string.theme_light)
                    AppTheme.SystemDefault -> stringResource(Res.string.theme_sys_default)
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
                settingAttribute = stringResource(Res.string.language),
                attributeValue = uiState.currentLanguage.name,
                settingIcon = Icons.Default.Language,
            ) {
                settingsViewModel.changeLanguageSelectionDialogState()
            }
        }

        SettingItemDialog(
            isDialogOpen = uiState.isThemeDialogOpen,
            appTheme = uiState.appTheme,
            settingsViewModel = settingsViewModel
        ) { theme ->
            settingsViewModel.changeAppTheme(theme)
            settingsViewModel.changeDialogOpenState()
        }

        if (uiState.isLanguageSelectionDialogOpen) {
            LanguageSelectionDialog(
                currentLanguage = uiState.currentLanguage,
                onLanguageSelected = {
                    settingsViewModel.changeAppLanguage(it)
                    settingsViewModel.changeLanguageSelectionDialogState()
                },
                onDialogDismissed = {
                    settingsViewModel.changeLanguageSelectionDialogState()
                }
            )
        }
    }
}
