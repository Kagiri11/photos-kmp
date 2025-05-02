package com.cmaina.photos.domain.repositories

import com.cmaina.photos.domain.models.settings.AppTheme
import com.cmaina.photos.presentation.utils.Language
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun saveAppLanguage(language: Language)
    suspend fun getAppLanguage(): Flow<Language>
    suspend fun saveAppTheme(theme: AppTheme)
    suspend fun getAppTheme(): Flow<AppTheme>
}
