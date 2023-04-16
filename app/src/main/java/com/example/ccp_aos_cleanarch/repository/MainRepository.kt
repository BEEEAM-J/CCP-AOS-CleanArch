package com.example.ccp_aos_cleanarch.repository

import com.example.ccp_aos_cleanarch.model.Categories

interface MainRepository {

    suspend fun getCategories(): Categories
}