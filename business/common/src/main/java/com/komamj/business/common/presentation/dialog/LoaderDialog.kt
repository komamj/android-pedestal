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

package com.komamj.business.common.presentation.dialog

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatDialogFragment
import com.komamj.business.common.R
import com.komamj.business.common.databinding.CommonDialogLoaderBinding
import com.komamj.business.common.util.TRANSITION_DURATION
import com.komamj.business.common.util.viewBinding

/**
 * @author komamj
 */
class LoaderDialog : AppCompatDialogFragment() {
    private val binding by viewBinding { CommonDialogLoaderBinding.bind(it) }
    private var dismissRequested = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.common_dialog)
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.common_dialog_loader, container, false)

    override fun dismiss() {
        dismissAllowingStateLoss()
    }

    override fun dismissAllowingStateLoss() {
        // Don't dismiss while we're animating, just wait to make loader animation smoother.
        if (view == null || (requireView().alpha > 0f && requireView().alpha < 1f))
            dismissRequested = true
        else hide()
    }

    override fun onStart() {
        super.onStart()

        if (dismissRequested) super.dismissAllowingStateLoss()
        else {
            binding.tvLoading.alpha = 0f
            binding.progressBar.alpha = 0f
            binding.tvLoading.translationY = -50 * resources.displayMetrics.density
            binding.tvLoading.animate()
                .translationY(0f)
                .alpha(1f)
                .setDuration(TRANSITION_DURATION).interpolator = OvershootInterpolator()
            binding.progressBar.animate()
                .alpha(1f)
                .setStartDelay(TRANSITION_DURATION)
                .setDuration(TRANSITION_DURATION)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        if (dismissRequested) hide()
                    }
                })
        }
    }

    private fun hide() {
        binding.progressBar.hide()
        binding.tvLoading.animate()
            .translationY(50 * resources.displayMetrics.density)
            .alpha(0f)
            .setDuration(TRANSITION_DURATION).setInterpolator(AccelerateInterpolator(2f))
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super@LoaderDialog.dismissAllowingStateLoss()
                }
            })
    }
}
