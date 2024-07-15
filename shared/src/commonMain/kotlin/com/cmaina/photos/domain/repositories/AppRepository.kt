package com.cmaina.photos.domain.repositories

import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun fetchAppTheme(): Flow<Boolean>

    suspend fun saveAppTheme(appTheme: Boolean)
}
