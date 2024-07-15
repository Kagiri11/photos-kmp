package com.cmaina.photos.domain.repositories

import com.cmaina.photos.domain.models.users.User
import com.cmaina.photos.domain.models.users.portfolio.UserPortFolioDomainModel
import com.cmaina.photos.domain.models.users.statistics.UserStatistics
import com.cmaina.photos.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun fetchUser(username: String): Flow<Result<User>>

    suspend fun fetchUserProfile(): Flow<User>


    suspend fun fetchUserPortFolio(): Flow<UserPortFolioDomainModel>

    suspend fun fetchUserStatistics(): Flow<UserStatistics>
}
