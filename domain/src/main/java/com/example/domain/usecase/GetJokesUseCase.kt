package com.example.domain.usecase

import com.example.domain.model.Jokes
import com.example.domain.repository.MainRepository

class GetJokesUseCase (private val repo: MainRepository) {

    suspend fun loadJokes(query : String?): Jokes {
        return repo.loadJokes(query)
    }
}