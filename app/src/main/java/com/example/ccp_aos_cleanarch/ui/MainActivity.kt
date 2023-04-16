package com.example.ccp_aos_cleanarch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.ccp_aos_cleanarch.R
import com.example.ccp_aos_cleanarch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel : MainViewModel by viewModels()

        GlobalScope.launch {
            Log.d("로그", "코루틴 정상 작동?")
            viewModel.loadCategories()
        }

        // 카테고리 데이터 받아오는데 성공하면?
        viewModel.categories.observe(this) {
            Log.d("카테고리", it.toString())
            var adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, it)
            binding.categorySpinner.adapter = adapter
        }

    }
}