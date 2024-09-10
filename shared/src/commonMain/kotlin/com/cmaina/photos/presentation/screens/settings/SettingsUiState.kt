package com.cmaina.photos.presentation.screens.settings

import androidx.compose.ui.unit.LayoutDirection
import com.cmaina.photos.domain.models.settings.AppTheme
import com.cmaina.photos.domain.models.settings.AppThemes
import com.cmaina.photos.presentation.utils.Language
import com.cmaina.photos.presentation.utils.LanguageList

data class SettingsUiState(
    val appTheme: AppTheme = AppThemes.first(),
    val isThemeDialogOpen: Boolean,
    val isLanguageSelectionDialogOpen: Boolean = false,
    val currentLanguage: Language = LanguageList.first(),
    val layoutDirection: LayoutDirection = LayoutDirection.Ltr
)