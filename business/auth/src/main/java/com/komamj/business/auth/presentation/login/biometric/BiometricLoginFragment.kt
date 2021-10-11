/*
 * Copyright 2021 komamj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.komamj.business.auth.presentation.login.biometric

import com.komamj.business.auth.R
import com.komamj.business.auth.databinding.AuthFragmentBiometricLoginBinding
import com.komamj.business.common.presentation.BaseFragment

/**
 * @author komamj
 * 生物识别登录
 */
class BiometricLoginFragment :
    BaseFragment<AuthFragmentBiometricLoginBinding, BiometricLoginViewModel>() {
    override fun provideViewModelClass() = BiometricLoginViewModel::class.java

    override fun provideLayoutId() = R.layout.auth_fragment_biometric_login
}
