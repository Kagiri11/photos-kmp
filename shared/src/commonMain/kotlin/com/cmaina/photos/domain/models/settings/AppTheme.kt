package com.cmaina.photos.domain.models.settings

import org.jetbrains.compose.resources.StringResource
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.theme_dark
import photos.shared.generated.resources.theme_light
import photos.shared.generated.resources.theme_sys_default

internal enum class ThemeType {
    LIGHT,
    DARK,
    SYSTEM
}

internal data class AppTheme(
    val entity: ThemeType,
    val themeResource: StringResource
)

internal val AppThemes = listOf(
    AppTheme(ThemeType.LIGHT, Res.string.theme_light),
    AppTheme(ThemeType.DARK, Res.string.theme_dark),
    AppTheme(ThemeType.SYSTEM, Res.string.theme_sys_default)
)