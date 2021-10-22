package com.interview.disney.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.interview.disney.domain.model.DisneyCharacter

data class CharacterDTO(
    @SerializedName("__v")
    val v: Int,
    @SerializedName("_id")
    val id: Int,
    @SerializedName("allies")
    val allies: List<String>,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("enemies")
    val enemies: List<String>,
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("parkAttractions")
    val parkAttractions: List<String>,
    @SerializedName("shortFilms")
    val shortFilms: List<String>,
    @SerializedName("sourceUrl")
    val sourceUrl: String,
    @SerializedName("tvShows")
    val tvShows: List<String>,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("videoGames")
    val videoGames: List<String>
)

fun CharacterDTO.toCharacter(): DisneyCharacter{
    return DisneyCharacter(
        id = id,
        allies = allies,
        createdAt = createdAt,
        enemies = enemies,
        films = films,
        imageUrl = imageUrl,
        name = name,
        parkAttractions = parkAttractions,
        shortFilms = shortFilms,
        sourceUrl = sourceUrl,
        tvShows = tvShows,
        updatedAt = updatedAt,
        url = url,
        videoGames = videoGames
    )
}