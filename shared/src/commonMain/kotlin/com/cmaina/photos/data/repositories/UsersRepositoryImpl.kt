package com.cmaina.photos.data.repositories

import com.cmaina.photos.data.network.models.users.UserDto
import com.cmaina.photos.data.mappers.toDomain
import com.cmaina.photos.data.network.InOut
import com.cmaina.photos.data.network.sources.UsersRemoteSource
import com.cmaina.photos.domain.models.users.User
import com.cmaina.photos.domain.models.users.portfolio.UserPortFolioDomainModel
import com.cmaina.photos.domain.models.users.statistics.UserStatistics
import com.cmaina.photos.domain.repositories.UsersRepository
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class UsersRepositoryImpl(
    private val usersRemoteSource: UsersRemoteSource
) : UsersRepository {

    override suspend fun fetchUser(username: String): Flow<Result<User>> {
        val response = usersRemoteSource.getUser(username = username)

        return flowOf(
            InOut<UserDto, User>(response.body())
                .apiCall(response) { it.toDomain() }
        )
    }

    override suspend fun fetchUserProfile(): Flow<User> {
        return flowOf()
    }

    override suspend fun fetchUserPortFolio(): Flow<UserPortFolioDomainModel> {
        return flowOf()
    }

    override suspend fun fetchUserStatistics(): Flow<UserStatistics> {
        return flowOf()
    }
}
