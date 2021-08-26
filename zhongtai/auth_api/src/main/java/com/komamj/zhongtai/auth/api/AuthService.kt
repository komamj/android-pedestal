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

package com.komamj.zhongtai.auth.api

import com.alibaba.android.arouter.facade.template.IProvider
import com.komamj.zhongtai.auth.api.data.entities.User
import org.jetbrains.annotations.Nullable

/**
 * @author komamj
 */
interface AuthService : IProvider {
    /**
     * 判断是否已经登录
     */
    fun isLogin(): Boolean

    /**
     * 退出登录
     */
    fun logout()

    /**
     * 获取当前登录的用户信息
     */
    @Nullable
    fun getCurrentUser(): User?
}
