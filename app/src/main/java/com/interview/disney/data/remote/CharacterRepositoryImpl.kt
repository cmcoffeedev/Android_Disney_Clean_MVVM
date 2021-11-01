package com.interview.disney.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.interview.disney.data.remote.dto.toCharacter
import com.interview.disney.domain.model.DisneyCharacter
import com.interview.disney.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val characterApi: CharacterApi) :
    CharacterRepository {

    override suspend fun getAllCharacters()  =
        Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { CharacterPagingSource(characterApi) })

    override suspend fun getSingleCharacter(characterId: Int): DisneyCharacter {
        return characterApi.getSingleCharacter(characterId).toCharacter()
    }
}