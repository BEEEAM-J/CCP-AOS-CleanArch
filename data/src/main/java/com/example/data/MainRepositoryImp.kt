package com.example.data

import com.example.data.network.ApiClient
import com.example.domain.model.Categories
import com.example.domain.model.Jokes
import com.example.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImp @Inject constructor(
    private val apiClient: ApiClient
    ): MainRepository {
    override suspend fun loadCategories(): Categories {
        return apiClient.getCategories()
    }

    override suspend fun loadJokes(query : String?): Jokes {
        return apiClient.getJokes(query)
    }
}