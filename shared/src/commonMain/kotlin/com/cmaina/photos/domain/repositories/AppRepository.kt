package com.cmaina.photos.domain.repositories

import com.cmaina.photos.domain.models.settings.AppTheme
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun fetchAppTheme(): Flow<AppTheme>

    suspend fun saveAppTheme(theme: AppTheme)
}
