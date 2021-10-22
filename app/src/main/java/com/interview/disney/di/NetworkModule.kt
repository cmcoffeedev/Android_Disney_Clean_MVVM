package com.interview.disney.di

import com.interview.disney.common.DisneyConstants
import com.interview.disney.data.remote.CharacterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(DisneyConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideCharacterApiClient(retrofit: Retrofit): CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }
}