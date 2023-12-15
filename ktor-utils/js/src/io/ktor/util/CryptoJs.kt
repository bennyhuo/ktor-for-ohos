/*
* Copyright 2014-2021 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
*/

package io.ktor.util

import io.ktor.util.ohos.*
import kotlinx.coroutines.*
import org.khronos.webgl.*
import kotlin.js.*

/**
 * Generates a nonce string.
 */
public actual fun generateNonce(): String {
    val buffer = when (PlatformUtils.platform) {
        Platform.Ohos -> {
            OhosCrypto.createRandom().generateRandomSync(NONCE_SIZE_IN_BYTES).data.asDynamic() as ByteArray
        }
        else -> _crypto.generateNonce()
    }
    return hex(buffer)
}

/**
 * Create [Digest] from specified hash [name].
 */
public actual fun Digest(name: String): Digest = object : Digest {
    private val state = mutableListOf<ByteArray>()
    override fun plusAssign(bytes: ByteArray) {
        state += bytes
    }

    override fun reset() {
        state.clear()
    }

    override suspend fun build(): ByteArray {
        val snapshot = state.reduce { a, b -> a + b }
        val digestView = if (PlatformUtils.IS_OHOS) {
            val md = OhosCrypto.createMd(name)
            val digestBuffer = md.digest(snapshot)
            DataView(digestBuffer.buffer, digestBuffer.byteOffset, digestBuffer.length)
        } else {
            val digestBuffer = _crypto.subtle.digest(name, snapshot).asDeferred().await()
            DataView(digestBuffer)
        }
        return ByteArray(digestView.byteLength) { digestView.getUint8(it) }
    }
}

// Variable is renamed to `_crypto` so it wouldn't clash with existing `crypto` variable.
// JS IR backend doesn't reserve names accessed inside js("") calls
private val _crypto: Crypto by lazy { // lazy because otherwise it's untestable due to evaluation order
    when (PlatformUtils.platform) {
        Platform.Node -> js("eval('require')('crypto')")
        else -> js("(window ? (window.crypto ? window.crypto : window.msCrypto) : self.crypto)")
    }
}

private external class Crypto {
    val subtle: SubtleCrypto

    fun getRandomValues(array: ByteArray)

    fun randomFillSync(array: ByteArray)
}

private external class SubtleCrypto {
    fun digest(algoName: String, buffer: ByteArray): Promise<ArrayBuffer>
}

private fun Crypto.generateNonce(): ByteArray {
    val buffer = ByteArray(NONCE_SIZE_IN_BYTES)
    when (PlatformUtils.platform) {
        Platform.Node -> _crypto.randomFillSync(buffer)
        else -> _crypto.getRandomValues(buffer)
    }
    return buffer
}

/**
 * Compute SHA-1 hash for the specified [bytes]
 */
public actual fun sha1(bytes: ByteArray): ByteArray = Sha1().digest(bytes)
