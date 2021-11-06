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

package com.komamj.zhongtai.banner

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerAdapter constructor(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    constructor(fragmentActivity: FragmentActivity) : this(
        fragmentActivity.supportFragmentManager,
        fragmentActivity.lifecycle
    )

    constructor(fragment: Fragment) : this(
        fragment.childFragmentManager,
        fragment.lifecycle
    )

    private val urls = ArrayList<String>()

    fun updateUrls(urls: List<String>) {
        this.urls.clear()
        this.urls.addAll(urls)
    }

    override fun getItemCount() = this.urls.size

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }
}
