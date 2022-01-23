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
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.komamj.platform.log.PlatformLog
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author komamj
 */
@AndroidEntryPoint
class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launcher_activity_launcher)

        PlatformLog.d("onCreate")

        handleIntent(intent)
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

        PlatformLog.d("onResume")
    }
}
