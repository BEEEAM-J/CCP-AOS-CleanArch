package com.example.ccp_aos_cleanarch.presentation.di

import com.example.ccp_aos_cleanarch.domain.repository.MainRepository
import com.example.ccp_aos_cleanarch.data.MainRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(impl: MainRepositoryImp): MainRepository
}