package com.example.ccp_aos_cleanarch.network

import com.example.ccp_aos_cleanarch.model.Categories
import com.example.ccp_aos_cleanarch.model.Jokes
import retrofit2.Call
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

