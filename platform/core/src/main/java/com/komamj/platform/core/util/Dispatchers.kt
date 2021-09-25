package com.komamj.platform.core.util

import kotlinx.coroutines.Dispatchers

/**
 * @author komamj
 */
object Dispatchers {
    fun default() = Dispatchers.Default

    fun ui() = Dispatchers.Main

    fun io() = Dispatchers.IO
}