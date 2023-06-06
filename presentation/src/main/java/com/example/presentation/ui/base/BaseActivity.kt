package com.example.presentation.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<B: ViewDataBinding, VM: ViewModel> (
    @LayoutRes private val layoutId: Int
): AppCompatActivity() {

    protected lateinit var binding: B
    protected abstract val viewModel: VM

    var backKeyPressTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this

        initView()
    }

    abstract fun initView()

    override fun onBackPressed() {
        if(System.currentTimeMillis() > (backKeyPressTime + 2500)){
            backKeyPressTime = System.currentTimeMillis()
            Toast.makeText(this@BaseActivity, "한번 더 누르면 종료 됩니다.", Toast.LENGTH_SHORT).show()
            return
        }
        else if(System.currentTimeMillis() <= (backKeyPressTime + 2500)){
            finish()
        }
    }

}