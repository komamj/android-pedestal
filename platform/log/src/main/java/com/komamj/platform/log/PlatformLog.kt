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

package com.komamj.platform.log

import android.app.Application
import com.komamj.platform.log.util.LOG_TAG
import timber.log.Timber

/**
 * @author komamj
 */
object PlatformLog {
    internal lateinit var application: Application

    @JvmStatic
    fun init(application: Application, isDebug: Boolean = true) {
        PlatformLog.application = application

        Timber.tag(LOG_TAG)
        if (isDebug) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    inline fun d(message: () -> String) {
        Timber.d(message.invoke())
    }

    inline fun e(throwable: Throwable, message: () -> String) {
        Timber.e(throwable, message.invoke())
    }
}
