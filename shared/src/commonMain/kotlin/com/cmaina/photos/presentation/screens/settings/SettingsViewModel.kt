package com.cmaina.photos.presentation.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmaina.photos.domain.models.settings.AppTheme
import com.cmaina.photos.domain.repositories.AppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(SettingsUiState(AppTheme.SystemDefault, false))
    val uiState = _uiState.asStateFlow()

    init {
        fetchAppTheme()
    }

    fun changeDialogOpenState() {
        println("Charlo App changing dialog state => ${_uiState.value}")
        _uiState.update { it.copy(isThemeDialogOpen = !_uiState.value.isThemeDialogOpen) }
    }

    private fun fetchAppTheme() = viewModelScope.launch {
        appRepository.fetchAppTheme().collect { theme ->
            println("Charlo App Theme vm => $theme")
            _uiState.update { it.copy(appTheme = theme) }
        }
    }

    fun changeAppTheme(theme: AppTheme) {
        viewModelScope.launch {
            appRepository.saveAppTheme(theme)
        }
    }
}

data class SettingsUiState(
    val appTheme: AppTheme,
    val isThemeDialogOpen: Boolean
)
