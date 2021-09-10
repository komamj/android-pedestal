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

package com.komamj.business.common.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.komamj.business.common.presentation.dialog.LoaderDialog

/**
 * @author komamj
 */
fun Fragment.showLoaderDialog() {
    /*
    We don't use navigation component here because navigating with navigation component is async and
    so if loading is really short and we immediately call hideLoaderDialog then dialog may never
    be closed.
     */
    activity?.supportFragmentManager?.let {
        if (it.findFragmentByTag(LoaderDialog::class.simpleName) == null)
            LoaderDialog().apply {
                showNow(it, LoaderDialog::class.simpleName)
            }
    }
    viewLifecycleOwnerLiveData.observe(this) {
        it.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                hideLoaderDialog()
            }
        })
    }
}

fun Fragment.hideLoaderDialog() {
    /*
    We don't use navigation component here because navigating with navigation component is async and
    so if loading is really short and we immediately call hideLoaderDialog then dialog may never
    be closed.
    */
    (
        activity?.supportFragmentManager?.findFragmentByTag(LoaderDialog::class.simpleName)
            as? LoaderDialog
        )?.dismissAllowingStateLoss()
}
