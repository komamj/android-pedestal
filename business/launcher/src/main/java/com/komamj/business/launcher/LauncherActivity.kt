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

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.komamj.business.common.architecture.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class LauncherActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")
        handleIntent(intent)
        setContentView(R.layout.launcher_activity_launcher)
        navigationTo()
    }

    private fun navigationTo() {
        var disposable = Observable.interval(3, TimeUnit.SECONDS)
            .take(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                ARouter.getInstance().build("/launcher/registerActivity")
                    .navigation(this)
            }, {
                Timber.e(it)
            })
        addDisposable(disposable)
    }

    private fun handleIntent(intent: Intent?) {
        intent?.data?.run {
            ARouter.getInstance().build(this)
                .navigation(
                    this@LauncherActivity,
                    object : NavCallback() {
                        override fun onArrival(postcard: Postcard?) {
                            finish()
                        }
                    }
                )
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")
    }
}
