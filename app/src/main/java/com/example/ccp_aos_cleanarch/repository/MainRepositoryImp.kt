package com.example.ccp_aos_cleanarch.repository

import com.example.ccp_aos_cleanarch.model.Categories
import com.example.ccp_aos_cleanarch.model.Jokes
import com.example.ccp_aos_cleanarch.network.ApiClient
import retrofit2.Call
import javax.inject.Inject

//@AndroidEntryPoint
class MainRepositoryImp @Inject constructor(
    private val apiClient: ApiClient
    ): MainRepository {
    override suspend fun getCategories(): Categories {
        return apiClient.getCategories()
    }

    override suspend fun getJokes(query : String): Jokes {
        return apiClient.getJokes(query)
    }
}