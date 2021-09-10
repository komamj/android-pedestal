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

package com.komamj.zhongtai.auth.util

import android.util.Patterns

fun <T> T.validate(validator: Validator<T>): Boolean = validator.validate(this)

interface Validator<in T> {
    fun validate(any: T?): Boolean
}

private class EmailValidator : Validator<CharSequence> {
    override fun validate(any: CharSequence?): Boolean =
        !any.isNullOrBlank() && Patterns.EMAIL_ADDRESS.matcher(any).matches()
}

val EMAIL_VALIDATOR: Validator<CharSequence> = EmailValidator()

private class PasswordValidator : Validator<CharSequence> {
    override fun validate(any: CharSequence?): Boolean = !any.isNullOrBlank() && any.length >= 8
}

val PASSWORD_VALIDATOR: Validator<CharSequence> = PasswordValidator()