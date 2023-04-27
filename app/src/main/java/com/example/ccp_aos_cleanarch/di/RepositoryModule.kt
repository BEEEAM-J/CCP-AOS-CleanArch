package com.example.ccp_aos_cleanarch.di

import com.example.data.MainRepositoryImp
import com.example.domain.repository.MainRepository
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