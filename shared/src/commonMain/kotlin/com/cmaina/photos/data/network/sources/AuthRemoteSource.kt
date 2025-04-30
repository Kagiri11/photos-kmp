package com.cmaina.photos.data.network.sources

import com.cmaina.photos.data.network.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.request.post

class AuthRemoteSource(private val client: HttpClient) {

    suspend fun authorizeUser(
        code: String,
        grantType: String = "authorization_code"
    ) = client.post("oauth/token") {
        url {
            parameters.append("client_id", Constants.CLIENT_ID)
            parameters.append("client_secret", Constants.CLIENT_SECRET)
            parameters.append("redirect_uri", Constants.REDIRECT_URI)
            parameters.append("code", code)
            parameters.append("grant_type", grantType)
        }
    }
}