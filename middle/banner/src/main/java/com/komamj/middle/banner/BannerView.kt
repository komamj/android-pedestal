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

package com.komamj.middle.banner

import android.content.Context
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Keep
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.HandlerCompat
import androidx.fragment.app.FragmentActivity
import com.komamj.middle.banner.databinding.BannerViewBinding

@Keep
class BannerView constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {
    private val binding = BannerViewBinding.bind(View.inflate(context, R.layout.banner_view, this))

    private val adapter = BannerAdapter(context as FragmentActivity)

    private val scrollHandler = HandlerCompat.createAsync(Looper.getMainLooper()) {
        if (it.what != MESSAGE_SCROLL) {
            return@createAsync false
        }

        val canScroll = scrollOnce()
        if (canScroll) {
            sendIntervalMessage()
        }

        return@createAsync true
    }

    private var delayTime = DEFAULT_DELAY_TIME

    private var isAutoScroll = true

    fun setAutoScroll(isAutoScroll: Boolean) {
        this.isAutoScroll = isAutoScroll
    }

    /**
     * 开始自动滚动
     */
    fun startAutoScroll() {
        isAutoScroll = true

        sendIntervalMessage()
    }

    private fun sendIntervalMessage() {
        if (!scrollHandler.hasMessages(MESSAGE_SCROLL)) {
            scrollHandler.sendEmptyMessageDelayed(MESSAGE_SCROLL, delayTime)
        }
    }

    /**
     * 停止自动滚动
     */
    fun stopAutoScroll() {
        isAutoScroll = false
        scrollHandler.removeMessages(MESSAGE_SCROLL)
    }

    /**
     * 更新Banner的数据源
     *
     * @param urls urls
     */
    fun submit(urls: List<String>) {
        adapter.updateUrls(urls)
    }

    private fun scrollOnce(): Boolean {
        if (adapter.itemCount <= 1 || !isAttachedToWindow) {
            return false
        }

        binding.viewPager2.currentItem = (binding.viewPager2.currentItem + 1)
            .coerceAtMost(adapter.itemCount - 1)

        return true
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        with(binding.viewPager2) {
            currentItem = 0
            offscreenPageLimit = 1
            adapter = this@BannerView.adapter
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        if (isAutoScroll) {
            startAutoScroll()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        scrollHandler.removeCallbacksAndMessages(null)
    }

    companion object {
        private const val DEFAULT_DELAY_TIME = 3000L
        private const val MESSAGE_SCROLL = 0
    }
}
