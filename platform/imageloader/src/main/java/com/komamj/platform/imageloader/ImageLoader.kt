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

package com.komamj.platform.imageloader

import android.app.Activity
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.komamj.platform.imageloader.util.load

object ImageLoader {
    @JvmStatic
    fun loadImage(
        fragment: Fragment,
        @DrawableRes placeHolderResId: Int,
        url: String?,
        view: ImageView
    ) {
        view.load(fragment, url, placeHolderResId)
    }

    @JvmStatic
    fun loadImage(
        activity: Activity,
        @DrawableRes placeHolderResId: Int,
        url: String,
        view: ImageView
    ) {
        view.load(activity, url, placeHolderResId)
    }

    @JvmStatic
    fun loadImage(
        fragmentActivity: FragmentActivity,
        @DrawableRes placeHolderResId: Int,
        url: String,
        view: ImageView
    ) {
        view.load(fragmentActivity, url, placeHolderResId)
    }
}
