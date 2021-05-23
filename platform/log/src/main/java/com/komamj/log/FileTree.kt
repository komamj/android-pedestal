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

package com.komamj.log

import android.util.Log
import android.util.PrintWriterPrinter
import android.util.Printer
import com.komamj.log.util.Dispatchers
import com.komamj.log.util.StorageUtils
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.regex.Pattern
import kotlin.math.min

internal class FileTree : Timber.Tree() {
    private val mainScope = MainScope()

    private var fileOutputStream: FileOutputStream? = null
    private var outputStream: OutputStreamWriter? = null
    private var printWriter: PrintWriter? = null

    private var logFilePath: String? = null
    private var mLogPrinter: Printer? = null
    private val mLogBuffer = StringBuilder()

    private val threadInfo: ThreadLocal<String> = object : ThreadLocal<String>() {
        override fun initialValue(): String {
            val thread = Thread.currentThread()
            return "${thread.name}(${thread.id})"
        }
    }

    init {
        mainScope.launch {
            withContext(Dispatchers.single) {
                initFile()
            }
        }
    }

    private fun initFile() {
        val spaceEnough = StorageUtils.isFreeSpaceEnough(10 * 1024 * 1024)
        var cacheDir: File? = PlatformLog.application.externalCacheDir
        if (cacheDir == null || !spaceEnough) {
            cacheDir = PlatformLog.application.cacheDir
        }
        if (cacheDir != null) {
            val logsDir = File(cacheDir, LOG_PATH)
            if (!logsDir.exists()) {
                val flag = logsDir.mkdirs()
                try {
                    if (!flag) {
                        Timber.e("mkdirs file:${logsDir.canonicalPath} failed")
                    } else {
                        Timber.e("mkdirs file:${logsDir.canonicalPath} successful")
                    }
                } catch (e: IOException) {
                    Timber.e(e, "Failed to init file logger")
                }
            }
            val logFile = File(
                logsDir,
                SimpleDateFormat("yyyy-MM-dd").format(Date()) + ".log"
            )
            var filePrinter: Printer? = null
            try {
                logFilePath = logFile.canonicalPath
                fileOutputStream = FileOutputStream(logFile, true)
                outputStream = OutputStreamWriter(fileOutputStream, "UTF-8")
                outputStream?.run {
                    printWriter = PrintWriter(this, true)
                    filePrinter = PrintWriterPrinter(printWriter)
                }
            } catch (e: IOException) {
                Timber.e("Failed to init file logger")
            }
            mLogPrinter = filePrinter
        } else {
            mLogPrinter = null
        }
    }

    override fun isLoggable(tag: String?, priority: Int): Boolean {
        return true
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        mainScope.launch {
            withContext(Dispatchers.single) {
                if (message.length < MAX_LOG_LENGTH) {
                    mLogBuffer.append(LOG_TIME_FORMATTER.format(Date()))
                        .append(" ")
                        .append(threadInfo)
                        .append(" ")
                        .append(message)
                    mLogPrinter?.println(mLogBuffer.toString())

                    if (priority == Log.ASSERT) {
                        Log.wtf(tag, message)
                    } else {
                        Log.println(priority, tag, message)
                    }
                    return@withContext
                }

                // Split by line, then ensure each line can fit into Log's maximum length.
                var i = 0
                val length = message.length
                while (i < length) {
                    var newline = message.indexOf('\n', i)
                    newline = if (newline != -1) newline else length
                    do {
                        val end = min(newline, i + MAX_LOG_LENGTH)
                        val part = message.substring(i, end)
                        if (priority == Log.ASSERT) {
                            Log.wtf(tag, part)
                        } else {
                            Log.println(priority, tag, part)
                        }
                        i = end
                    } while (i < newline)
                    i++
                }
            }
        }
    }

    companion object {
        private const val LOG_PATH = "logs"
        private const val MAX_LOG_LENGTH = 4000
        private const val MAX_TAG_LENGTH = 23
        private val ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$")
        private const val DATE_PATTERN = "yyyy-MM-dd HH:mm:sss"
        private val LOG_TIME_FORMATTER = SimpleDateFormat(DATE_PATTERN)
        private const val LOGGER_THREAD = "logger-thread"
    }
}
