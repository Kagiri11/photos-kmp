package com.cmaina.photos.presentation.screens.settings

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.cmaina.photos.domain.models.settings.AppThemeEntity
import com.cmaina.photos.presentation.components.settingscomponents.LanguageSelectionDialog
import com.cmaina.photos.presentation.components.settingscomponents.Setting
import com.cmaina.photos.presentation.components.settingscomponents.ThemeDialog
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.display
import photos.shared.generated.resources.language
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
                color = MaterialTheme.colorScheme.onBackground,
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
                /*style = MaterialTheme.typography.body1.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )*/
            )

            Setting(
                settingAttribute = stringResource(Res.string.theme),
                attributeValue = stringResource(uiState.appTheme.themeResource),
                settingIcon = when (uiState.appTheme.entity) {
                    AppThemeEntity.SYSTEM -> if (isSystemInDarkTheme()) Icons.Default.DarkMode else Icons.Default.LightMode
                    AppThemeEntity.DARK -> Icons.Default.DarkMode
                    AppThemeEntity.LIGHT -> Icons.Default.LightMode
                },
            ) {
                settingsViewModel.changeDialogOpenState()
            }

            Setting(
                settingAttribute = stringResource(Res.string.language),
                attributeValue = stringResource(uiState.currentLanguage.resource),
                settingIcon = Icons.Default.Language,
            ) {
                settingsViewModel.changeLanguageSelectionDialogState()
            }
        }
        if (uiState.isThemeDialogOpen) {
            ThemeDialog(
                appTheme = uiState.appTheme,
                settingsViewModel = settingsViewModel
            ) { theme ->
                settingsViewModel.changeAppTheme(theme)
                settingsViewModel.changeDialogOpenState()
            }
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
