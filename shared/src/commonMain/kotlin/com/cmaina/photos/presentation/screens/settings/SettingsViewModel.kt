package com.cmaina.photos.presentation.screens.settings

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

    private val _uiState = MutableStateFlow(SettingsUiState(AppTheme.SystemDefault, false))
    val uiState = _uiState.asStateFlow()

    init {
        fetchAppTheme()
        fetchAppLanguage()
    }

    fun changeDialogOpenState() {
        _uiState.update { it.copy(isThemeDialogOpen = !_uiState.value.isThemeDialogOpen) }
    }

    private fun fetchAppTheme() = viewModelScope.launch {
        appRepository.fetchAppTheme().collect { theme ->
            _uiState.update { it.copy(appTheme = theme) }
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

    fun fetchAppLanguage() = viewModelScope.launch {
        appRepository.fetchAppLanguage().collect { language ->
            _uiState.update { it.copy(currentLanguage = language) }
        }
    }
}

data class SettingsUiState(
    val appTheme: AppTheme,
    val isThemeDialogOpen: Boolean,
    val isLanguageSelectionDialogOpen: Boolean = false,
    val currentLanguage: Language = Language.English
)
