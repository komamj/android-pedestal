package com.komamj.business.common.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.komamj.platform.log.PlatformLog
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun ViewModel.ioLaunch(block: suspend CoroutineScope.() -> Unit) {
    this.viewModelScope.launch(Dispatchers.IO) {
        block.invoke(this)
    }
}

fun ViewModel.mainLaunch(block: suspend CoroutineScope.() -> Unit) {
    this.viewModelScope.launch(Dispatchers.Main) {
        try {
            block.invoke(this)
        } catch (exception: Exception) {
            PlatformLog.e(exception, "${coroutineContext[CoroutineName]}")
        }
    }
}