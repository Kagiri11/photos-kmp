package com.cmaina.photos.data.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.cmaina.photos.data.mappers.toDomain
import com.cmaina.photos.data.network.sources.AuthRemoteSource
import com.cmaina.photos.data.network.InOut
import com.cmaina.photos.data.network.models.auth.AuthRemoteResponse
import com.cmaina.photos.domain.models.auth.AuthDomainResponse
import com.cmaina.photos.domain.repositories.AuthRepository
import com.cmaina.photos.domain.utils.Result
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthRepositoryImpl(
    private val authRemoteSource: AuthRemoteSource,
    private val preferences: DataStore<Preferences>,
) : AuthRepository {

    private val userAuthenticatedPref = booleanPreferencesKey("userAuthenticated")

    override suspend fun authenticateUser(authCode: String): Result<AuthDomainResponse> {
        val call = authRemoteSource.authorizeUser(code = authCode)
        return InOut<AuthRemoteResponse, AuthDomainResponse>(call.body())
            .apiCall(response = call) { it.toDomain() }
    }

    override suspend fun saveUserAuthentication(accessToken: String) {
        /*   AppSettings.putString(key = "access_token", accessToken)
           AppSettings.putBoolean(key = "isUserAuthenticated", true)*/
    }

    override suspend fun clearStaleUserAuthentication() {
        preferences.edit {
            it[userAuthenticatedPref] = false
        }
    }

    override suspend fun checkIfUserHasBeenAuthenticated(): Flow<Boolean> {
        return preferences.data.map {
            it[userAuthenticatedPref] ?: false
        }
    }
}
