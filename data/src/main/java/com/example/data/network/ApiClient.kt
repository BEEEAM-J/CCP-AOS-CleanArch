package com.example.data.network

import com.example.domain.model.Categories
import com.example.domain.model.Jokes
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

