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

package com.komamj.business.common

import com.alibaba.android.arouter.launcher.ARouter
import com.komamj.platform.core.CoreApplication
import com.komamj.platform.log.PlatformLog

/**
 * @author komamj
 */
open class CommonApplication : CoreApplication() {
    override fun onCreate() {
        super.onCreate()
        PlatformLog.init(application = this, BuildConfig.DEBUG)
        PlatformLog.d("onCreate")
        initRouter()
    }

    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}
