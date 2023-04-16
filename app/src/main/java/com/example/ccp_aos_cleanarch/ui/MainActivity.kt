package com.example.ccp_aos_cleanarch.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.ccp_aos_cleanarch.R
import com.example.ccp_aos_cleanarch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 카테고리 데이터 받아오기 성공
        viewModel.categories.observe(this) {
            var adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, it)
            binding.categorySpinner.adapter = adapter

//          배경 투명도 조절
            binding.mainLayout.setBackgroundColor(Color.parseColor("#5644e6"));

//          ProgressBar 숨기기
            binding.loadingStatus.visibility= View.GONE

//          터치 방지 해제
            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    }

    override fun onResume() {
        super.onResume()

        GlobalScope.launch {
            viewModel.loadCategories()
        }


    }
}