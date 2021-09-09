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

package com.komamj.business.common.widget

import androidx.annotation.Keep
import androidx.viewpager2.widget.ViewPager2

/**
 * @author komamj
 */
@Keep
interface PageIndicator {
    /**
     * Bind the indicator to a ViewPager.
     *
     * @param view
     */
    fun setViewPager(view: ViewPager2?)

    /**
     * Bind the indicator to a ViewPager.
     *
     * @param view
     * @param initialPosition
     */
    fun setViewPager(view: ViewPager2?, initialPosition: Int)

    /**
     *
     * Set the current page of both the ViewPager and indicator.
     *
     *
     * This **must** be used if you need to set the page before
     * the views are drawn on screen (e.g., default start page).
     *
     * @param item
     */
    fun setCurrentItem(item: Int)

    /**
     * Register a page change listener which will receive forwarded events.
     *
     * @param callback
     */
    fun registerOnPageChangeCallback(callback: ViewPager2.OnPageChangeCallback?)

    /**
     * Unregister a page change listener which will receive forwarded events.
     *
     * @param callback
     */
    fun unregisterOnPageChangeCallback(callback: ViewPager2.OnPageChangeCallback?)

    /**
     * Notify the indicator that the fragment list has changed.
     */
    fun notifyDataSetChanged()
}
