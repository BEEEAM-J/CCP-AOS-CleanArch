package com.example.domain.usecase

import com.example.domain.model.Jokes
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetJokesUseCase @Inject constructor(private val repo: MainRepository) {

    suspend fun loadJokes(query : String?): Jokes {
        return repo.loadJokes(query)
    }
}