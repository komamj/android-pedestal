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

package com.platform.core.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import com.komamj.business.common.presentation.AlertDialog
import com.komamj.business.common.presentation.setDialogPositiveClickListener

/**
 * Make sure we are in the right destination before navigating to other destination.
 * This is useful for example when receiving data from [AlertDialog] with
 * [setDialogPositiveClickListener] for example and dialog has not be dismissed yet and so current
 * destination id is still not fragment destination id where you may want to navigate elsewhere.
 */
fun Fragment.navigateWhenCurrentDestinationIdIs(destinationId: Int, readyToNavigate: () -> Unit) {
    val listener = object :
        NavController.OnDestinationChangedListener {
        override fun onDestinationChanged(
            controller: NavController,
            destination: NavDestination,
            arguments: Bundle?
        ) {
            if (destination.id == destinationId) {
                readyToNavigate.invoke()
                findNavController().removeOnDestinationChangedListener(this)
            }
        }
    }

    findNavController().addOnDestinationChangedListener(listener)

    viewLifecycleOwnerLiveData.observe(this@navigateWhenCurrentDestinationIdIs) {
        it.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                findNavController().removeOnDestinationChangedListener(listener)
            }
        })
    }
}

/**
 * Make sure we are in the right destination to navigate to other destination.
 * This is useful for example when you open a dialog and try to navigate from fragment that opened
 * the dialog, you'll get a crash since current destination is not the right one.
 */
fun Fragment.navigateIfCurrentDestinationIdIs(destinationId: Int, readyToNavigate: () -> Unit) {
    if (findNavController().currentDestination?.id == destinationId) readyToNavigate.invoke()
}
