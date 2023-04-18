package com.example.ccp_aos_cleanarch.ui

import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ccp_aos_cleanarch.model.Categories
import com.example.ccp_aos_cleanarch.model.Jokes
import com.example.ccp_aos_cleanarch.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel() {

    private val _categories = MutableLiveData<Categories>()
    val categories: LiveData<Categories> = _categories

    private val _jokes = MutableLiveData<Jokes>()
    val jokes: LiveData<Jokes> = _jokes


    suspend fun loadCategories() {
        Log.d("로그(뷰모델)", "뷰모델 정상 작동 확인")
        val loadedCategories: Categories = repository.getCategories()
        loadedCategories?.let {
            _categories.postValue(it)
            Log.d("로그(뷰모델)", it.toString())
        }
    }

    suspend fun loadJokes(query : String?) {
        Log.d("로그(뷰모델)", "버튼 정상 작동 확인")
        val loadedJokes: Jokes = repository.getJokes(query)
        loadedJokes?.let {
            _jokes.postValue(it)
            Log.d("로그(뷰모델)", it.toString())

        }
    }


}