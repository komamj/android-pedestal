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

package com.komamj.business.launcher

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.komamj.business.common.architecture.presentation.BaseFragment
import com.komamj.business.launcher.databinding.LauncherFragmentLauncherBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LauncherFragment : BaseFragment<LauncherFragmentLauncherBinding, LauncherViewModel>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("onViewCreated")
        viewModel.waitForNavigation()
        viewModel.navigation.observe(viewLifecycleOwner, {
            ARouter.getInstance().build("/launcher/registerActivity")
                .navigation(context)
        })
    }

    override fun provideLayoutId() = R.layout.launcher_fragment_launcher

    override fun provideViewModelClass() = LauncherViewModel::class.java
}
