package com.cmaina.photos.data.repositories.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cmaina.photos.data.mappers.toDomain
import com.cmaina.photos.data.network.InOut
import com.cmaina.photos.data.network.sources.PhotosRemoteSource
import com.cmaina.photos.data.network.models.search.PhotoSearchResultDto
import com.cmaina.photos.domain.models.photos.Photo
import com.cmaina.photos.domain.models.search.PhotoSearchResultDomainModel
import io.ktor.client.call.body

class SearchedPhotosPagingSource(
    private val photosRemoteSource: PhotosRemoteSource,
    private val searchString: String
) : PagingSource<Int, Photo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val nextPageNumber = params.key ?: 1
        val call = photosRemoteSource.searchPhotos(
            searchQuery = searchString,
            page = nextPageNumber
        )
        val result = InOut<PhotoSearchResultDto, PhotoSearchResultDomainModel>(call.body())
            .apiCall(response = call) { it.toDomain() }

        return when {
            result.isSuccess -> {
                val dataResponse = result.getOrThrow().searchedPhotoDomainModels
                LoadResult.Page(
                    data = dataResponse ?: emptyList(),
                    prevKey = null,
                    nextKey = nextPageNumber + (params.loadSize / 10)
                )
            }

            else -> {
                LoadResult.Error(throwable = Throwable(result.exceptionOrNull()))
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
