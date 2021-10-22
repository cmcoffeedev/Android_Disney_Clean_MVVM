package com.interview.disney.di

import com.interview.disney.data.remote.CharacterApi
import com.interview.disney.data.remote.CharacterRepositoryImpl
import com.interview.disney.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideCharacterRepository(characterApi: CharacterApi): CharacterRepository {
        return CharacterRepositoryImpl(characterApi)
    }
}