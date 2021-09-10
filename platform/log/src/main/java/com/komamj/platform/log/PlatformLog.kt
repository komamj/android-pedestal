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

    /** Log a verbose message with optional format args. */
    @JvmStatic
    fun v(message: String?, vararg args: Any?) {
        Timber.v(message, args)
    }

    /** Log a verbose exception and a message with optional format args. */
    @JvmStatic
    fun v(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.v(t, message, args)
    }

    /** Log a verbose exception. */
    @JvmStatic
    fun v(t: Throwable?) {
        Timber.v(t)
    }

    /** Log a debug message with optional format args. */
    @JvmStatic
    fun d(message: String?, vararg args: Any?) {
        Timber.d(message, args)
    }

    /** Log a debug exception and a message with optional format args. */
    @JvmStatic
    fun d(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.d(t, message, args)
    }

    /** Log a debug exception. */
    @JvmStatic
    fun d(t: Throwable?) {
        Timber.d(t)
    }

    /** Log an info message with optional format args. */
    @JvmStatic
    fun i(message: String?, vararg args: Any?) {
        Timber.i(message, args)
    }

    /** Log an info exception and a message with optional format args. */
    @JvmStatic
    fun i(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.i(t, message, args)
    }

    /** Log an info exception. */
    @JvmStatic
    fun i(t: Throwable?) {
        Timber.i(t)
    }

    /** Log a warning message with optional format args. */
    @JvmStatic
    fun w(message: String?, vararg args: Any?) {
        Timber.w(message, args)
    }

    /** Log a warning exception and a message with optional format args. */
    @JvmStatic
    fun w(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.w(t, message, args)
    }

    /** Log a warning exception. */
    @JvmStatic
    fun w(t: Throwable?) {
        Timber.w(t)
    }

    /** Log an error message with optional format args. */
    @JvmStatic
    fun e(message: String?, vararg args: Any?) {
        Timber.e(message, args)
    }

    /** Log an error exception and a message with optional format args. */
    @JvmStatic
    fun e(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.e(t, message, args)
    }

    /** Log an error exception. */
    @JvmStatic
    fun e(t: Throwable?) {
        Timber.e(t)
    }

    /** Log an assert message with optional format args. */
    @JvmStatic
    fun wtf(message: String?, vararg args: Any?) {
        Timber.wtf(message, args)
    }

    /** Log an assert exception and a message with optional format args. */
    @JvmStatic
    fun wtf(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.wtf(t, message, args)
    }

    /** Log an assert exception. */
    @JvmStatic
    fun wtf(t: Throwable?) {
        Timber.wtf(t)
    }

    /** Log at `priority` a message with optional format args. */
    @JvmStatic
    fun log(priority: Int, message: String?, vararg args: Any?) {
        Timber.log(priority, message, args)
    }

    /** Log at `priority` an exception and a message with optional format args. */
    @JvmStatic
    fun log(priority: Int, t: Throwable?, message: String?, vararg args: Any?) {
        Timber.log(priority, t, message, args)
    }

    /** Log at `priority` an exception. */
    @JvmStatic
    fun log(priority: Int, t: Throwable?) {
        Timber.log(priority, t)
    }
}
