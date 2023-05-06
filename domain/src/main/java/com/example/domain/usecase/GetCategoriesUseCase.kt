package com.example.domain.usecase

import com.example.domain.model.Categories
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repo : MainRepository) {

    suspend fun loadCategories(): Categories {
        return repo.loadCategories()
    }

}