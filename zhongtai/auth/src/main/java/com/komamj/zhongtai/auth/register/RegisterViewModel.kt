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

package com.komamj.zhongtai.auth.register

import com.komamj.business.common.architecture.presentation.BaseViewModel
import com.komamj.zhongtai.auth.data.source.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author komamj
 */
@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: AuthRepository) :
    BaseViewModel() {
    fun register(phoneNumber: String) {
    }
}
