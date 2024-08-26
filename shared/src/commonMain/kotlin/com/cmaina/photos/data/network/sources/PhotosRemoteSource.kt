package com.cmaina.photos.data.network.sources

import io.ktor.client.HttpClient
import io.ktor.client.request.get


class PhotosRemoteSource(private val client: HttpClient) {

    suspend fun fetchPhotos(page: Int) = client.get("photos") {
        url {
            parameters.append("page", "$page")
        }
    }

    suspend fun fetchPhoto(id: String) = client.get("photos/$id")

    suspend fun fetchRandomPhoto() = client.get("photos/random")

    suspend fun likePhoto(id: String) = client.get("photos/$id/like")

    suspend fun fetchPhotoStatistics(id: String) =
        client.get("photos/$id/statistics")

    suspend fun searchPhotos(
        searchQuery: String,
        page: Int
    ) = client.get("search/photos") {
        url {
            parameters.append("query", searchQuery)
            parameters.append("page", page.toString())
        }
    }

}