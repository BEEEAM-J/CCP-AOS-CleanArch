package com.example.ccp_aos_cleanarch.network

import com.example.ccp_aos_cleanarch.model.Categories
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject

interface ApiClient {

    @GET("jokes/categories")
    suspend fun getCategories() : Categories
}

