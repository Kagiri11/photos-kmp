package com.cmaina.photos.data.network.sources

import com.cmaina.fotos.shared.data.Constants.BASEURL
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class UsersRemoteSource(private val client: HttpClient) {

    suspend fun getUser(username: String) = client.get("users/$username")

    suspend fun getUserPhotos(
        username: String,
        page: Int
    ) = client.get("users/$username/photos") {
        url {
            parameters.append("page", "$page")
        }
    }
}