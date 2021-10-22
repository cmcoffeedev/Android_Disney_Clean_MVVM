package com.interview.disney.domain.model


data class DisneyCharacter(
    val id: Int,
    val allies: List<String>,
    val createdAt: String,
    val enemies: List<String>,
    val films: List<String>,
    val imageUrl: String,
    val name: String,
    val parkAttractions: List<String>,
    val shortFilms: List<String>,
    val sourceUrl: String,
    val tvShows: List<String>,
    val updatedAt: String,
    val url: String,
    val videoGames: List<String>
)
