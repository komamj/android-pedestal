package com.komamj.zhongtai.auth.presentation.login.gesture

import com.komamj.business.common.presentation.BaseFragment
import com.komamj.zhongtai.auth.R
import com.komamj.zhongtai.auth.databinding.AuthFragmentGestureLoginBinding

/**
 * @author komamj
 * 手势识别登录
 */
class GestureLoginFragment :
    BaseFragment<AuthFragmentGestureLoginBinding, GestureLoginViewModel>() {
    override fun provideViewModelClass() = GestureLoginViewModel::class.java

    override fun provideLayoutId() = R.layout.auth_fragment_gesture_login
}