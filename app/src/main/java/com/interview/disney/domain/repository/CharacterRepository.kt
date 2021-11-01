package com.interview.disney.domain.repository

import androidx.paging.Pager
import com.interview.disney.domain.model.DisneyCharacter


interface CharacterRepository {
    suspend fun getAllCharacters(): Pager<Int, DisneyCharacter>
    suspend fun getSingleCharacter(characterId:Int): DisneyCharacter
}