package com.example.anorbank.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.anorbank.data.model.remote.response.historyResponse.Child
import com.example.anorbank.data.source.remote.MyApi

class TestPaginationSource(private val api: MyApi) : PagingSource<Int, Child>() {

    override fun getRefreshKey(state: PagingState<Int, Child>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1) ?: state.closestPageToPosition(
                anchor
            )?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Child> {

        val page = params.key ?: 1
        return try {
            val apiResponse = api.getHistory(50, page)
            val apiResponse1=apiResponse.body()!!.childList
            LoadResult.Page(
                data = apiResponse1,
                nextKey = if (apiResponse.body()!!.page > page) page.plus(1) else null,
                prevKey = if (page > 1) page.minus(1) else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}