package com.example.ccp_aos_cleanarch.repository

import com.example.ccp_aos_cleanarch.model.Categories
import com.example.ccp_aos_cleanarch.network.ApiClient
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//@AndroidEntryPoint
class MainRepositoryImp @Inject constructor(private val apiClient: ApiClient): MainRepository {
    override suspend fun getCategories(): Categories {
        return apiClient.getCategories()
    }
}