package com.cmaina.photos.data.repositories.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cmaina.photos.data.mappers.toDomain
import com.cmaina.photos.data.network.InOut
import com.cmaina.fotos.shared.data.network.PhotosRemoteSource
import com.cmaina.photos.data.network.models.photos.PhotoListItem
import com.cmaina.photos.domain.models.photos.Photo
import io.ktor.client.call.body

class PhotosPagingSource(private val photosRemoteSource: PhotosRemoteSource) :
    PagingSource<Int, Photo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val nextPageNumber = params.key ?: 1
        val call = photosRemoteSource.fetchPhotos(page = nextPageNumber)
        val result = InOut<List<PhotoListItem>, List<Photo>>(call.body())
            .apiCall(call) { it.map { it.toDomain() } }
        return when (result) {
            is com.cmaina.photos.domain.utils.Result.Success -> {
                val dataResponse = result.data
                LoadResult.Page(
                    data = dataResponse,
                    prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                    nextKey = if (dataResponse.isEmpty()) null else nextPageNumber + 1
                )
            }

            is com.cmaina.photos.domain.utils.Result.Error -> {
                LoadResult.Error(Throwable(message = result.errorDetails))
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition = anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
