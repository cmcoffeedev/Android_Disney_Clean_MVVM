package com.interview.disney.data.remote

import com.interview.disney.data.remote.dto.toCharacter
import com.interview.disney.domain.model.DisneyCharacter
import com.interview.disney.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val characterApi: CharacterApi) :
    CharacterRepository {

    override suspend fun getAllCharacters(): List<DisneyCharacter> {
        return characterApi.getCharacters().characters.map { it.toCharacter() }
    }

    override suspend fun getSingleCharacter(characterId: Int): DisneyCharacter {
        return characterApi.getSingleCharacter(characterId).toCharacter()
    }
}