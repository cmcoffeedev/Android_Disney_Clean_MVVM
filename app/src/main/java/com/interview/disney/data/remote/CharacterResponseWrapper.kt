package com.interview.disney.data.remote

import com.google.gson.annotations.SerializedName
import com.interview.disney.data.remote.dto.CharacterDTO

data class CharacterResponseWrapper(
    @SerializedName("data")
    val characters: List<CharacterDTO>,
    @SerializedName("count")
    val count : Int,
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("nextPage")
    val nextPage: String

)

