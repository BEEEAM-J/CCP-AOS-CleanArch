package com.example.domain.repository

import com.example.domain.model.Categories
import com.example.domain.model.Jokes

interface MainRepository {

    suspend fun getCategories(): Categories

    suspend fun  getJokes(query : String?): Jokes
}