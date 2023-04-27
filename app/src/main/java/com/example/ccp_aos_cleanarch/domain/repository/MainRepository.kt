package com.example.ccp_aos_cleanarch.domain.repository

import com.example.ccp_aos_cleanarch.data.Categories
import com.example.ccp_aos_cleanarch.data.Jokes

interface MainRepository {

    suspend fun getCategories(): Categories

    suspend fun  getJokes(query : String?): Jokes
}