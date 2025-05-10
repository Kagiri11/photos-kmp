package com.cmaina.photos.data.repositories

import com.cmaina.photos.data.mappers.toDomain
import com.cmaina.photos.data.network.InOut
import com.cmaina.photos.data.network.sources.UsersRemoteSource
import com.cmaina.photos.domain.models.users.User
import com.cmaina.photos.domain.models.users.portfolio.UserPortFolioDomainModel
import com.cmaina.photos.domain.models.users.statistics.UserStatistics
import com.cmaina.photos.domain.repositories.UsersRepository
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class UsersRepositoryImpl(
    private val usersRemoteSource: UsersRemoteSource
) : UsersRepository {

    override suspend fun getUser(username: String): Result<User> {
        try {
            val user = usersRemoteSource.getUser(username = "jack")
            return Result.success(user)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun fetchUserPortFolio(): Flow<UserPortFolioDomainModel> {
        return flowOf()
    }

    override suspend fun fetchUserStatistics(): Flow<UserStatistics> {
        return flowOf()
    }
}
