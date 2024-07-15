package com.cmaina.photos.domain.repositories

import com.cmaina.photos.domain.models.auth.AuthDomainResponse
import com.cmaina.fotos.shared.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun authenticateUser(authCode: String): Result<AuthDomainResponse>

    suspend fun saveUserAuthentication(accessToken: String)

    suspend fun clearStaleUserAuthentication()

    suspend fun checkIfUserHasBeenAuthenticated(): Flow<Boolean>
}
