package com.example.ccp_aos_cleanarch.di

import com.example.domain.repository.MainRepository
import com.example.domain.usecase.GetCategoriesUseCase
import com.example.domain.usecase.GetJokesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Singleton
    @Provides
    fun providesCategoryUseCase(repo: MainRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(repo)
    }

    @Singleton
    @Provides
    fun providesJokeUseCase(repo: MainRepository): GetJokesUseCase {
        return GetJokesUseCase(repo)
    }

}