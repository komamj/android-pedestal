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

package com.komamj.zhongtai.citypicker.widget

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Keep
import androidx.annotation.NonNull
import androidx.annotation.Nullable

@Keep
class SideIndexBar constructor(
    @NonNull context: Context?,
    @Nullable attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {

    private var listener: OnIndexChangeListener? = null

    fun setListener(listener: OnIndexChangeListener?) {
        this.listener = listener
    }

    private val indexItems = ArrayList<String>()

    fun setIndexItems(indexItems: List<String>) {
        this.indexItems.clear()
        this.indexItems.addAll(indexItems)
        invalidate()
    }

    init {
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    interface OnIndexChangeListener {
        fun onIndexChange(index: String)
    }
}
