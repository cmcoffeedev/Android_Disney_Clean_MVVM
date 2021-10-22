package com.interview.disney.domain.repository

import com.interview.disney.domain.model.DisneyCharacter


interface CharacterRepository {
    suspend fun getAllCharacters(): List<DisneyCharacter>
    suspend fun getSingleCharacter(characterId:Int): DisneyCharacter
}