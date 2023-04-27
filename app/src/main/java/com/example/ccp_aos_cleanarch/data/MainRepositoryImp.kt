package com.example.ccp_aos_cleanarch.data

import com.example.ccp_aos_cleanarch.domain.repository.MainRepository
import com.example.ccp_aos_cleanarch.data.network.ApiClient
import javax.inject.Inject

class MainRepositoryImp @Inject constructor(
    private val apiClient: ApiClient
    ): MainRepository {
    override suspend fun getCategories(): Categories {
        return apiClient.getCategories()
    }

    override suspend fun getJokes(query : String?): Jokes {
        return apiClient.getJokes(query)
    }
}