// ktlint-disable filename
/*
* Copyright 2014-2021 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
*/

package io.ktor.util

internal actual val PlatformUtils.isDevelopmentMode: Boolean
    get() = false

internal actual val PlatformUtils.isNewMemoryModel: Boolean
    get() = true

public actual val PlatformUtils.platform: Platform
    get() {
        val hasNodeApi = js(
            """
                (typeof process !== 'undefined' 
                    && process.versions != null 
                    && process.versions.node != null) ||
                (typeof window !== 'undefined' 
                    && typeof window.process !== 'undefined' 
                    && window.process.versions != null 
                    && window.process.versions.node != null)
                """
        ) as Boolean

        val hasWindowApi = js(
                """
                typeof window !== 'undefined'
                """
        ) as Boolean
        return if (hasNodeApi) {
            Platform.Node
        } else if(hasWindowApi) {
            Platform.Browser
        } else {
            Platform.Ohos
        }
    }
