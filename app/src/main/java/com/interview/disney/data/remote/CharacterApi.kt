package com.interview.disney.data.remote

import com.interview.disney.common.DisneyConstants
import com.interview.disney.data.remote.dto.CharacterDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    @GET(DisneyConstants.CHARACTERS)
    suspend fun getCharacters(
        @Query(DisneyConstants.PAGE_QUERY)
        page: Int
    ):CharacterResponseWrapper

    @GET("${DisneyConstants.CHARACTERS}/{${DisneyConstants.CHARACTER_PATH}}")
    suspend fun getSingleCharacter(
        @Path(DisneyConstants.CHARACTER_PATH)
        id: Int
    ):CharacterDTO

}