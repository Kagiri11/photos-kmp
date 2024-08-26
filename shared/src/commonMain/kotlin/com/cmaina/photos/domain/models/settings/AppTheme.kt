package com.cmaina.photos.domain.models.settings

import androidx.compose.material.Colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.ui.graphics.vector.ImageVector
import com.cmaina.photos.presentation.ui.theme.LightColorPalette
import com.cmaina.photos.presentation.ui.theme.DarkColorPalette
import com.cmaina.photos.presentation.utils.ThemeListener
import org.jetbrains.compose.resources.StringResource
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.theme_dark
import photos.shared.generated.resources.theme_light
import photos.shared.generated.resources.theme_sys_default

enum class AppThemeEntity {
    LIGHT,
    DARK,
    SYSTEM
}

data class AppTheme(
    val entity: AppThemeEntity,
    val themeResource: StringResource,
    val icon: ImageVector,
    val palette: Colors
)


val AppThemes = listOf(
    AppTheme(
        AppThemeEntity.LIGHT,
        Res.string.theme_light,
        Icons.Default.LightMode,
        LightColorPalette
    ),
    AppTheme(AppThemeEntity.DARK, Res.string.theme_dark, Icons.Default.DarkMode, DarkColorPalette),
    AppTheme(
        AppThemeEntity.SYSTEM,
        Res.string.theme_sys_default,
        if (ThemeListener.isAppInDarkTheme.value) Icons.Default.DarkMode else Icons.Default.LightMode,
        if (ThemeListener.isAppInDarkTheme.value) DarkColorPalette else LightColorPalette
    )
)