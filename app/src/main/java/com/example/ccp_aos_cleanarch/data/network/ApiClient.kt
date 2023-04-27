package com.example.ccp_aos_cleanarch.data.network

import com.example.ccp_aos_cleanarch.data.Categories
import com.example.ccp_aos_cleanarch.data.Jokes
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("jokes/categories")
    suspend fun getCategories() : Categories

    @GET("jokes/random")
    suspend fun getJokes(
        @Query("category") category : String?
    ): Jokes
}

