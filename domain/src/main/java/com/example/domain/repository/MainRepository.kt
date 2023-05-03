package com.example.domain.repository

import com.example.domain.model.Categories
import com.example.domain.model.Jokes

interface MainRepository {

    suspend fun loadCategories(): Categories

    suspend fun loadJokes(query : String?): Jokes
}