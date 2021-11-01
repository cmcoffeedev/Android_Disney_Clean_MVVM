package com.interview.disney.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.interview.disney.data.remote.dto.toCharacter
import com.interview.disney.domain.model.DisneyCharacter
import java.io.IOException

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class CharacterPagingSource(
    private val characterApi: CharacterApi,
): PagingSource<Int, DisneyCharacter>() {


    override  suspend fun load(params: LoadParams<Int>): LoadResult<Int,DisneyCharacter>{
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX

        return try{
            val response = characterApi.getCharacters( position )
            val results = response.characters.map { it.toCharacter() }
            LoadResult.Page(
                data = results,
                prevKey = if(position == CHARACTER_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if(results.isEmpty()) null else position + 1
            )
        }
        catch(e: IOException){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DisneyCharacter>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPageIndex = state.pages.indexOf(state.closestPageToPosition(anchorPosition))
            state.pages.getOrNull(anchorPageIndex + 1)?.prevKey ?: state.pages.getOrNull(anchorPageIndex - 1)?.nextKey
        }

    }
}
