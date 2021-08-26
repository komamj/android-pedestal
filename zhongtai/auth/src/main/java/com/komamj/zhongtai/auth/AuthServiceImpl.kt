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

package com.komamj.zhongtai.auth

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.komamj.zhongtai.auth.api.AuthService
import com.komamj.zhongtai.auth.api.data.entities.User

@Route(path = "auth/service")
class AuthServiceImpl : AuthService {
    override fun init(context: Context?) {
        TODO("Not yet implemented")
    }

    override fun isLogin(): Boolean {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser(): User? {
        TODO("Not yet implemented")
    }
}
