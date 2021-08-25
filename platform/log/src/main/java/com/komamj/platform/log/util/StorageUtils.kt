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

package com.komamj.platform.log.util

import android.os.Environment
import android.os.StatFs
import com.komamj.platform.log.PlatformLog
import java.io.File

object StorageUtils {
    // Checks if a volume containing external storage is available for read and write.
    fun isExternalStorageWritable(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }

    // Checks if a volume containing external storage is available to at least read.
    fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in
            setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
    }

    /**
     * 获取SD卡剩余空间
     * 单位为byte
     * @return SD卡剩余空间 free space
     */
    fun getFreeSpace(): Long {
        if (!isExternalStorageWritable()) {
            return 0
        }
        return PlatformLog.application.externalCacheDir?.let {
            val stat = StatFs(it.path + File.separator)
            val blockSize = stat.blockSizeLong
            val availableBlocks = stat.availableBlocksLong
            availableBlocks * blockSize
        } ?: 0
    }

    /**
     * Is free space enough boolean.
     *
     * @param buffer the buffer
     * @return the boolean
     */
    fun isFreeSpaceEnough(buffer: Long): Boolean {
        return getFreeSpace() - buffer > 0
    }
}
