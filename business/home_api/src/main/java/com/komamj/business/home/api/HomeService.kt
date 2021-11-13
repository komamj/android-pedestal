package com.komamj.business.home.api

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.template.IProvider

interface HomeService : IProvider {
    /**
     * 提供首页 Fragment
     */
    fun provideHomeFragment(): Fragment
}