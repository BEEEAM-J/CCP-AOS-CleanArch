package com.example.domain.repository

import com.example.domain.model.Categories
import com.example.domain.model.Jokes
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    suspend fun loadCategories(): Categories

    suspend fun loadJokes(query : String?): Jokes
}