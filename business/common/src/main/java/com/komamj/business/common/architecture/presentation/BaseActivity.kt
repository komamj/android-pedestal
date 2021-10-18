package com.komamj.business.common.architecture.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected lateinit var binding: DB
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), provideLayoutId(), null, false)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(provideViewModelClass())
    }

    protected abstract fun provideViewModelClass(): Class<VM>

    protected abstract fun provideLayoutId(): Int
}