package com.example.ccp_aos_cleanarch.repository

import com.example.ccp_aos_cleanarch.model.Categories
import com.example.ccp_aos_cleanarch.model.Jokes

interface MainRepository {

    suspend fun getCategories(): Categories

    suspend fun  getJokes(query : String?): Jokes
}