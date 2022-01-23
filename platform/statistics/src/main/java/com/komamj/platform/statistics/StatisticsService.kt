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

package com.komamj.platform.statistics

import android.content.Context

/**
 * @author komamj
 */
interface StatisticsService {
    /**
     * 预初始化，不会采集设备信息，也不会向后台上报数据
     */
    fun preInit(context: Context, appKey: String, channel: String)

    /**
     * 正式初始化
     */
    fun init(
        context: Context,
        appKey: String,
        channel: String,
        deviceType: Int,
        pushSecret: String
    )
}
