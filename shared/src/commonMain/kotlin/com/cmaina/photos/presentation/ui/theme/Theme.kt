package com.cmaina.photos.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.cmaina.photos.domain.models.settings.AppTheme
import com.cmaina.photos.presentation.screens.settings.SettingsUiState
import com.cmaina.photos.presentation.screens.settings.SettingsViewModel
import com.cmaina.photos.presentation.utils.ThemeListener
import kotlinx.coroutines.flow.update
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

val DarkColorPalette = darkColors(
    primary = FotosBlack,
    primaryVariant = FotosGreyShadeThreeLightTheme,
    secondary = FotosBlack,
    background = FotosBlack,
    surface = FotosBlack,
    onPrimary = FotosWhite,
    onSecondary = FotosWhite,
    onBackground = FotosWhite,
    onSurface = FotosWhite
)

val LightColorPalette = lightColors(
    primary = FotosWhite,
    primaryVariant = FotosGreyShadeThreeLightTheme,
    secondary = FotosBlack,
    background = FotosWhite,
    surface = FotosWhite,
    onPrimary = FotosBlack,
    onSecondary = FotosBlack,
    onBackground = FotosBlack,
    onSurface = FotosBlack,
)

@Composable
fun PhotosTheme(
    uiState: SettingsUiState,
    content: @Composable () -> Unit
) {
    ThemeListener.isAppInDarkTheme.update { isSystemInDarkTheme() }
    val colors = uiState.appTheme.palette

    MaterialTheme(
        colors = colors,
        content = content
    )
}