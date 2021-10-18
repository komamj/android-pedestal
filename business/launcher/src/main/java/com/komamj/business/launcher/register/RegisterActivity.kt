package com.komamj.business.launcher.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.alibaba.android.arouter.facade.annotation.Route
import com.komamj.business.common.architecture.presentation.BaseActivity
import com.komamj.business.launcher.LauncherViewModel
import com.komamj.business.launcher.R
import com.komamj.business.launcher.databinding.LauncherFragmentLauncherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = "/launcher/registerActivity")
open class RegisterActivity() : BaseActivity<LauncherFragmentLauncherBinding,RegisterViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun provideLayoutId() = R.layout.activity_register
    override fun provideViewModelClass() = RegisterViewModel::class.java

}