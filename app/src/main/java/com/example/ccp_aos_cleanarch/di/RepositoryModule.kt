package com.example.ccp_aos_cleanarch.di

import com.example.ccp_aos_cleanarch.repository.MainRepository
import com.example.ccp_aos_cleanarch.repository.MainRepositoryImp
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