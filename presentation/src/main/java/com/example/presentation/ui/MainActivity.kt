package com.example.presentation.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.view.WindowManager
import android.view.animation.AnticipateInterpolator
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.asLiveData
import com.example.domain.model.Categories
import com.example.presentation.MainState
import com.example.presentation.R
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var categoryPos : String? = null
    private lateinit var cateList : Categories

    private val viewModel : MainViewModel by viewModels()

    // 스플래시 화면
    private lateinit var splashScreen: SplashScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadCategories()

        Timber.d("Timber Test Log ")

        // 스플래시 화면은 setContentView 전에 install 해야함
        splashScreen = installSplashScreen()
        startSplash()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.root.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (viewModel.isReady) {
                        binding.root.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        false
                    }
                }
            }
        )

        // UiState 관찰
        viewModel.uiState.asLiveData().observe(this) {
            when(it) {
                is MainState.Loading -> {

                }
                // 카테고리 로딩 완료
                is MainState.CategoryLoaded -> {
                    var adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, viewModel.categories.value)
                    binding.categorySpinner.adapter = adapter

                    cateList = viewModel.categories.value
                    Log.d("로그(액티비티)", cateList.toString())

                    // 배경 투명도 조절
                    binding.mainLayout.setBackgroundColor(Color.parseColor("#5644e6"));
                    // ProgressBar 숨기기
                    binding.loadingStatus.visibility= View.GONE
                    // 터치 방지 해제
                    window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                }
                // 농담 로딩 완료
                is MainState.JokeLoaded -> {
                    binding.jokes = viewModel.jokes.value
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()

        // 농담 불러오는 버튼 클릭 시
        binding.printBtn.setOnClickListener {
            Log.d("버튼 클릭", categoryPos.toString())
            categoryPos?.let { query ->
                if (categoryPos == "random") {
                    viewModel.loadJokes(null)
                }
                else
                    viewModel.loadJokes(query)
            }
        }

        binding.categorySpinner.setSelection(0)
//      스피너의 아이템이 클릭 되었을 때 동작
        binding.categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                선택된 카테고리를 String으로 받아옴
                categoryPos = cateList[p2]

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

    private fun startSplash() {
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.5f, 0.7f)
            val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.5f, 0.7f)

            ObjectAnimator.ofPropertyValuesHolder(splashScreenView.iconView, scaleX, scaleY).run {
                interpolator = AnticipateInterpolator()
                duration = 2000L
                doOnEnd {
                    splashScreenView.remove()
                }
                start()
            }
        }
    }


}