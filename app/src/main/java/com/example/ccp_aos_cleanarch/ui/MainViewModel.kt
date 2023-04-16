package com.example.ccp_aos_cleanarch.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ccp_aos_cleanarch.model.Categories
import com.example.ccp_aos_cleanarch.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel() {

    private val _categories = MutableLiveData<Categories>()
    val categories: LiveData<Categories> = _categories

    suspend fun loadCategories() {
        Log.d("로그", "뷰모델 정상 작동 확인")
        val loadedCategories: Categories = repository.getCategories()
        loadedCategories?.let {
            _categories.postValue(it)
        }
    }
}