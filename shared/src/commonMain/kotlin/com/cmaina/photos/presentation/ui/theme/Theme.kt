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
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

private val DarkColorPalette = darkColors(
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

private val LightColorPalette = lightColors(
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
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (uiState.appTheme) {
        AppTheme.Light -> LightColorPalette
        AppTheme.Dark -> DarkColorPalette
        AppTheme.SystemDefault -> if (darkTheme) DarkColorPalette else LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}