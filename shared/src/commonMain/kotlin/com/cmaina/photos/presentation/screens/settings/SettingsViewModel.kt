package com.cmaina.photos.presentation.screens.settings

import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmaina.photos.domain.models.settings.AppTheme
import com.cmaina.photos.domain.repositories.AppRepository
import com.cmaina.photos.presentation.utils.Language
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(SettingsUiState(isThemeDialogOpen = false))
    val uiState = _uiState.asStateFlow()

    init {
        fetchAppTheme()
        fetchAppLanguage()
        getLayoutDirection()
    }

    fun changeDialogOpenState() {
        _uiState.update {
            it.copy(isThemeDialogOpen = !_uiState.value.isThemeDialogOpen)
        }
    }

    fun changeAppTheme(theme: AppTheme) {
        viewModelScope.launch {
            appRepository.saveAppTheme(theme)
        }
    }

    fun changeLanguageSelectionDialogState() {
        _uiState.update { it.copy(isLanguageSelectionDialogOpen = !_uiState.value.isLanguageSelectionDialogOpen) }
    }

    fun changeAppLanguage(language: Language) {
        viewModelScope.launch {
            appRepository.saveAppLanguage(language)
        }
    }

    private fun fetchAppLanguage() = viewModelScope.launch {
        appRepository.fetchAppLanguage().collect { language ->
            _uiState.update { it.copy(currentLanguage = language) }
            getLayoutDirection()
        }
    }

    private fun getLayoutDirection() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    layoutDirection = if (it.currentLanguage.shouldShowInRTL) LayoutDirection.Rtl
                    else LayoutDirection.Ltr
                )
            }
        }
    }

    private fun fetchAppTheme() = viewModelScope.launch {
        appRepository.fetchAppTheme().collect { theme ->
            _uiState.update { it.copy(appTheme = theme) }
        }
    }
}


