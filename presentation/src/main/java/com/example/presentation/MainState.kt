package com.example.presentation

import com.example.domain.model.Categories
import com.example.domain.model.Jokes

sealed class MainState {
    object Loading : MainState()
    data class CategoryLoaded(var list: Categories) : MainState()
    data class JokeLoaded(var list: Jokes): MainState()
}