package com.cmaina.photos.data.repositories

import com.cmaina.photos.domain.repositories.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class AppRepositoryImpl(

) : AppRepository {

    override suspend fun fetchAppTheme(): Flow<Boolean> {
        return flowOf(false)
    }

    override suspend fun saveAppTheme(appTheme: Boolean) {}

}
