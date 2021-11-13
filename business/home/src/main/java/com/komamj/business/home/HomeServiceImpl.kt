package com.komamj.business.home

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.komamj.business.home.api.HomeService

@Route(path = "home/main")
class HomeServiceImpl : HomeService {
    override fun init(context: Context?) {
    }

    override fun provideHomeFragment() = HomeFragment.newInstance()
}