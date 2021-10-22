package com.interview.disney.presentation

import com.interview.disney.domain.model.DisneyCharacter

interface CharacterClickListener {
    fun clickedCharacter(character: DisneyCharacter)
}