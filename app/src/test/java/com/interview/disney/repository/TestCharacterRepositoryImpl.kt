package com.interview.disney.repository

import com.google.gson.Gson
import com.interview.disney.data.remote.CharacterResponseWrapper
import com.interview.disney.data.remote.dto.CharacterDTO
import com.interview.disney.data.remote.dto.toCharacter
import com.interview.disney.domain.model.DisneyCharacter
import com.interview.disney.domain.repository.CharacterRepository
import com.interview.disney.testutility.MockFileReader
import okhttp3.mockwebserver.MockResponse

class TestCharacterRepositoryImpl: CharacterRepository {
    private val gson = Gson()
    override suspend fun getAllCharacters(): List<DisneyCharacter> {

        val fakeResponse = gson.fromJson(
            MockFileReader("characters.json").getFakeJsonResponse(),
            CharacterResponseWrapper::class.java
        )

        return fakeResponse.characters.map { it.toCharacter() }
    }

    override suspend fun getSingleCharacter(characterId: Int): DisneyCharacter {

        val fakeResponse = gson.fromJson(
            MockFileReader("single_character.json").getFakeJsonResponse(),
            CharacterDTO::class.java
        )

        return fakeResponse.toCharacter()
    }
}