package com.interview.disney.data.remote

import com.interview.disney.common.DisneyConstants
import com.interview.disney.data.remote.dto.CharacterDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET(DisneyConstants.CHARACTERS)
    suspend fun getCharacters():CharacterResponseWrapper

    @GET("${DisneyConstants.CHARACTERS}/{${DisneyConstants.CHARACTER_PATH}}")
    suspend fun getSingleCharacter(
        @Path(DisneyConstants.CHARACTER_PATH)
        id: Int
    ):CharacterDTO

}