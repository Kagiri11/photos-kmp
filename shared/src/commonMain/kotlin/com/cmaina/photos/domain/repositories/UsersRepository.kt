package com.cmaina.photos.domain.repositories

import com.cmaina.photos.domain.models.users.User
import com.cmaina.photos.domain.models.users.portfolio.UserPortFolioDomainModel
import com.cmaina.photos.domain.models.users.statistics.UserStatistics
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun fetchUserPortFolio(): Flow<UserPortFolioDomainModel>
    suspend fun getUser(username: String): Result<User>
    suspend fun fetchUserStatistics(): Flow<UserStatistics>
}
