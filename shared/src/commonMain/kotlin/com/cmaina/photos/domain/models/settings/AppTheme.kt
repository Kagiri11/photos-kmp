package com.cmaina.photos.domain.models.settings

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
    val themeResource: StringResource
)


val AppThemes = listOf(
    AppTheme(
        AppThemeEntity.LIGHT,
        Res.string.theme_light
    ),
    AppTheme(AppThemeEntity.DARK, Res.string.theme_dark),
    AppTheme(
        AppThemeEntity.SYSTEM,
        Res.string.theme_sys_default
    )
)