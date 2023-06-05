package com.example.presentation.ui.base

import android.os.Bundle
import android.os.PersistableBundle
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

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        preload()

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this

        delaySplash()
        initView()
    }

    protected abstract fun initView()
    abstract fun preload()
    abstract fun delaySplash()
}