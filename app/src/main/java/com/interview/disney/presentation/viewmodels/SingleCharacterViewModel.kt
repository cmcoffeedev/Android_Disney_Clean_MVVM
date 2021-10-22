package com.interview.disney.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.disney.common.Resource
import com.interview.disney.domain.model.DisneyCharacter
import com.interview.disney.domain.use_case.GetSingleCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SingleCharacterViewModel @Inject constructor(private val singleCharacterUseCase : GetSingleCharacterUseCase) : ViewModel() {

    private val mCharacter = MutableLiveData<DisneyCharacter>()


    fun character(): LiveData<DisneyCharacter> = mCharacter

    fun getSingleCharacter(id: Int) {
        singleCharacterUseCase(id).onEach { characterResource ->
            when (characterResource) {
                is Resource.Success -> {
                    val characters = characterResource.data
                    mCharacter.postValue(characters)
                }
                is Resource.Loading -> {
                }
                is Resource.Error -> {
                }

            }
        }.launchIn(viewModelScope)

    }

}