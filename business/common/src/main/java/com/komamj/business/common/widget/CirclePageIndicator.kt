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

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager2.widget.ViewPager2

/**
 * @author komamj
 */
class CirclePageIndicator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs), PageIndicator {
    override fun setViewPager(view: ViewPager2?) {
        TODO("Not yet implemented")
    }

    override fun setViewPager(view: ViewPager2?, initialPosition: Int) {
        TODO("Not yet implemented")
    }

    override fun setCurrentItem(item: Int) {
        TODO("Not yet implemented")
    }

    override fun registerOnPageChangeCallback(callback: ViewPager2.OnPageChangeCallback?) {
        TODO("Not yet implemented")
    }

    override fun unregisterOnPageChangeCallback(callback: ViewPager2.OnPageChangeCallback?) {
        TODO("Not yet implemented")
    }

    override fun notifyDataSetChanged() {
        TODO("Not yet implemented")
    }
}
