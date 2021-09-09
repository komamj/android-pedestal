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

@file:Suppress("unused")

package com.platform.core.util

import android.text.format.DateFormat
import com.platform.core.CoreApplication
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToLong

/**
 * @author komamj
 *
 * Input in milliseconds
 */
fun Long.formatDuration() = this.div(1000f).roundToLong().let {
    "%d:%02d:%02d".format(
        it / 3600,
        (it % 3600) / 60,
        it % 60
    )
}

fun Long.formatShortDateTime(timeZone: TimeZone? = null) = "%s • %s".format(
    DateFormat.getDateFormat(CoreApplication.appContext).apply {
        timeZone?.let { this.timeZone = it }
    }.format(this),
    DateFormat.getTimeFormat(CoreApplication.appContext).apply {
        timeZone?.let { this.timeZone = it }
    }.format(this)
)

fun Long.formatShortDate(timeZone: TimeZone? = null) = "%s".format(
    DateFormat.getDateFormat(CoreApplication.appContext).apply {
        timeZone?.let { this.timeZone = it }
    }.format(this)
)

fun Long.formatMediumDateTime(timeZone: TimeZone? = null) = "%s • %s".format(
    DateFormat.getMediumDateFormat(CoreApplication.appContext).apply {
        timeZone?.let { this.timeZone = it }
    }.format(this),
    DateFormat.getTimeFormat(CoreApplication.appContext).apply {
        timeZone?.let { this.timeZone = it }
    }.format(this)
)

fun Long.formatMediumDate(timeZone: TimeZone? = null) = "%s".format(
    DateFormat.getMediumDateFormat(CoreApplication.appContext).apply {
        timeZone?.let { this.timeZone = it }
    }.format(this)
)

fun Long.formatLongDateTime(timeZone: TimeZone? = null) = "%s • %s".format(
    DateFormat.getLongDateFormat(CoreApplication.appContext).apply {
        timeZone?.let { this.timeZone = it }
    }.format(this),
    DateFormat.getTimeFormat(CoreApplication.appContext).apply {
        timeZone?.let { this.timeZone = it }
    }.format(this)
)

fun Long.formatLongDate(timeZone: TimeZone? = null) = "%s".format(
    DateFormat.getLongDateFormat(CoreApplication.appContext).apply {
        timeZone?.let { this.timeZone = it }
    }.format(this)
)

fun Long.formatBest(pattern: String): String = SimpleDateFormat(
    DateFormat.getBestDateTimePattern(Locale.getDefault(), pattern),
    Locale.getDefault()
).format(this)
