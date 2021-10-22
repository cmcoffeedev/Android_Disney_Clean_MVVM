package com.interview.disney.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.disney.common.Resource
import com.interview.disney.domain.model.DisneyCharacter
import com.interview.disney.domain.use_case.GetAllCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val getAllCharactersUseCase: GetAllCharactersUseCase) :
    ViewModel() {

    private val mCharacters = MutableLiveData<List<DisneyCharacter>>()

    init {
        getCharacters()
    }

    private fun getCharacters() {

        getAllCharactersUseCase().onEach { characterResource ->
            when (characterResource) {
                is Resource.Success -> {
                    val characters = characterResource.data
                    mCharacters.postValue(characters)
                }
                is Resource.Loading -> {
                }
                is Resource.Error -> {
                }
            }

        }.launchIn(viewModelScope)

    }

    fun characters(): LiveData<List<DisneyCharacter>> = mCharacters

}