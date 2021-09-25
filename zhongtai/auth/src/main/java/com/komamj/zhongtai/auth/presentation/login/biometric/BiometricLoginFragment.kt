package com.komamj.zhongtai.auth.presentation.login.biometric

import com.komamj.business.common.presentation.BaseFragment
import com.komamj.zhongtai.auth.R
import com.komamj.zhongtai.auth.databinding.AuthFragmentBiometricLoginBinding

/**
 * @author komamj
 * 生物识别登录
 */
class BiometricLoginFragment :
    BaseFragment<AuthFragmentBiometricLoginBinding, BiometricLoginViewModel>() {
    override fun provideViewModelClass() = BiometricLoginViewModel::class.java

    override fun provideLayoutId() = R.layout.auth_fragment_biometric_login
}