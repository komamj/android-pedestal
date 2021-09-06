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

package com.komamj.business.common.architecture.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * @author komamj
 */
abstract class BaseAdapter<D, VH : BaseViewHolder> constructor(
    diffCallback: DiffUtil.ItemCallback<D> = object : DiffUtil.ItemCallback<D>() {
        override fun areItemsTheSame(oldItem: D, newItem: D) = false
        override fun areContentsTheSame(oldItem: D, newItem: D) = false
    },
) : ListAdapter<D, VH>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return createBinding(parent, viewType)
    }

    protected abstract fun createBinding(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        bind(holder, getItem(position))
        holder.binding.executePendingBindings()
    }

    abstract fun bind(holder: VH, item: D)
}
