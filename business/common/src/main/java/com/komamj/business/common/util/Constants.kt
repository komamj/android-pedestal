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

@file:Suppress("unused")

package com.komamj.business.common.util

import com.komamj.business.common.R
import com.komamj.platform.core.CoreApplication

// Transition
val TRANSITION_DURATION =
    CoreApplication.appContext.resources.getInteger(R.integer.common_transition_duration).toLong()
val TRANSITION_DURATION_SHORT =
    CoreApplication.appContext.resources.getInteger(R.integer.common_transition_duration_short)
        .toLong()
