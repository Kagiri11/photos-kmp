package com.cmaina.photos.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.cmaina.photos.domain.models.settings.AppThemeEntity
import com.cmaina.photos.presentation.screens.settings.SettingsUiState

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
    val colors = when (uiState.appTheme.entity) {
        AppThemeEntity.LIGHT -> LightColorPalette
        AppThemeEntity.DARK -> DarkColorPalette
        AppThemeEntity.SYSTEM -> if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}