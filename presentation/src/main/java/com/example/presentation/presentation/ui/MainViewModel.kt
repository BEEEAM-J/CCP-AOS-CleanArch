package com.example.presentation.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Categories
import com.example.domain.model.Jokes
import com.example.domain.usecase.GetCategoriesUseCase
import com.example.domain.usecase.GetJokesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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

//    private val _categories = MutableLiveData<Categories>()
//    val categories: LiveData<Categories> = _categories

//    private val _jokes = MutableLiveData<Jokes>()
//    val jokes: LiveData<Jokes> = _jokes


    suspend fun loadCategories() = viewModelScope.launch {
        val loadedCategories = CategoriesUseCase.loadCategories()
        loadedCategories?.let {
            _categories.value = it
            Log.d("로그(뷰모델)", it.toString())
        }
    }

    suspend fun loadJokes(query : String?) = viewModelScope.launch{
        val loadedJokes = JokesUseCase.loadJokes(query)
        loadedJokes?.let {
            _jokes.value = it
            Log.d("로그(뷰모델)", it.toString())
        }
    }


}