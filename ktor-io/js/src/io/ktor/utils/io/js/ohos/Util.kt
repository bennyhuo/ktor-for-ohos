package io.ktor.utils.io.js.ohos

import io.ktor.utils.io.js.Decoder
import org.khronos.webgl.ArrayBufferView
import org.khronos.webgl.Uint8Array

@JsModule("@ohos.util")
@JsNonModule
internal external class Util {
    internal class TextDecoder(encoding: String, options: dynamic = definedExternally) {
        val encoding: String

       fun decodeWithStream(buffer: Uint8Array, options: dynamic = definedExternally): String
    }
}

internal fun Util.TextDecoder.toKtor(): Decoder = object : Decoder {
    override fun decode(): String = decodeWithStream(Uint8Array(0))
    override fun decode(buffer: ArrayBufferView): String {
        return decodeWithStream(Uint8Array(buffer.buffer, buffer.byteOffset, buffer.byteLength))
    }
    override fun decode(buffer: ArrayBufferView, options: dynamic): String {
        return decodeWithStream(Uint8Array(buffer.buffer, buffer.byteOffset, buffer.byteLength), options)
    }
}
