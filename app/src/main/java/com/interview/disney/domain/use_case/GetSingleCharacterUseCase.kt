package com.interview.disney.domain.use_case

import com.interview.disney.common.Resource
import com.interview.disney.domain.model.DisneyCharacter
import com.interview.disney.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSingleCharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {


    operator fun invoke(characterId: Int) = flow<Resource<DisneyCharacter>> {
        try {
            emit(Resource.Loading())
            val character = characterRepository.getSingleCharacter(characterId)
            emit(Resource.Success(character))
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Please check your internet connection."))
        }
    }
}