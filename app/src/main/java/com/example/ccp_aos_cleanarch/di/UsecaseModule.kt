package com.example.ccp_aos_cleanarch.di

import com.example.data.network.ApiClient
import com.example.domain.model.Categories
import com.example.domain.usecase.GetCategories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UsecaseModule {

//    @Singleton
//    @Provides
//    fun providesCategories(api: ApiClient): ApiClient{
//        return api
//    }

}