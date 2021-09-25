package com.komamj.platform.core.util

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

/**
 * @author komamj
 */
class GlobalCoroutineExceptionHandler(override val key: CoroutineContext.Key<*>) :
    CoroutineExceptionHandler {
    override fun handleException(context: CoroutineContext, exception: Throwable) {
        // TODO: 2021/9/11 handle exception
    }
}