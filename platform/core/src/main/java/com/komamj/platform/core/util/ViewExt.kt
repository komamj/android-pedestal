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

package com.komamj.platform.core.util

import android.view.View

/**
 * @author komamj
 */

fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        // We're already attached, just request as normal.
        requestApplyInsets()
    } else {
        // We're not attached to the hierarchy, add a listener to
        // request when we are.
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.removeOnAttachStateChangeListener(this)
                v.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}

private const val DEFAULT_DEBOUNCE_TIME = 1200

fun View.setDebounceOnClickListener(
    listener: (View) -> Unit,
    debounceTime: Int = DEFAULT_DEBOUNCE_TIME
) {
    var lastClickTime: Long = 0
    setOnClickListener {
        if (System.currentTimeMillis() - lastClickTime >= debounceTime) {
            listener.invoke(it)
            lastClickTime = System.currentTimeMillis()
        }
    }
}
