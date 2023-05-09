package com.example.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Categories
import com.example.domain.model.Jokes
import com.example.domain.usecase.GetCategoriesUseCase
import com.example.domain.usecase.GetJokesUseCase
import com.example.presentation.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val CategoriesUseCase: GetCategoriesUseCase,
    private val JokesUseCase: GetJokesUseCase
): ViewModel() {

    private val _categories = MutableStateFlow(Categories())
    val categories: StateFlow<Categories> = _categories

    private val _jokes = MutableStateFlow(Jokes("", "", "", "Very Simple Joke App"))
    val jokes: StateFlow<Jokes> = _jokes

    private val _uiState = MutableStateFlow<MainState>(MainState.Loading)
    val uiState = _uiState.asStateFlow()

//    lateinit var loadedCategories: Categories

//    private val _categories = MutableLiveData<Categories>()
//    val categories: LiveData<Categories> = _categories

//    private val _jokes = MutableLiveData<Jokes>()
//    val jokes: LiveData<Jokes> = _jokes

    init {
        GlobalScope.launch {
            loadCategories()
        }
    }

    // uiState 값 조정할 메서드
//    fun abc() {
//        if (loadedCategories.size == 1) {
//            _uiState.value = MainState.Loading
//        }
//        else if (loadedCategories.size > 1) {
//            _uiState.value = MainState.CategoryLoaded(loadedCategories)
//        }
//    }

    private suspend fun loadCategories() = viewModelScope.launch {
        val loadedCategories = CategoriesUseCase.loadCategories()
        loadedCategories?.let {
            _categories.value = it
            Log.d("로그(뷰모델)", it.toString())
            _uiState.value = MainState.CategoryLoaded(loadedCategories)
        }

    }

    suspend fun loadJokes(query : String?) = viewModelScope.launch{
        val loadedJokes = JokesUseCase.loadJokes(query)
        loadedJokes?.let {
            _jokes.value = it
            Log.d("로그(뷰모델)", it.toString())
            _uiState.value = MainState.JokeLoaded(loadedJokes)
        }
    }


}