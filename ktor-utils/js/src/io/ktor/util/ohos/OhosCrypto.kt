package io.ktor.util.ohos

import kotlinx.coroutines.*
import org.khronos.webgl.*
import kotlin.js.Promise

/**
 * Created by Benny Huo on 2023/12/8
 */
@JsModule("@ohos.security.cryptoFramework")
@JsNonModule
public external class OhosCrypto {

    public interface DataBlob {
        /**
         * Indicates the content of data blob.
         *
         * @type { Uint8Array }
         * @syscap SystemCapability.Security.CryptoFramework
         * @since 9
         */
        public var data: Uint8Array
    }

    public interface Random {
        /**
         * Generate random DataBlob by given length.
         *
         * @param { number } len - indicates the length of random DataBlob.
         * @returns { Promise<DataBlob> } the promise used to return the generated random blob.
         * @throws { BusinessError } 401 - invalid parameters.
         * @throws { BusinessError } 17620001 - memory error.
         * @throws { BusinessError } 17630001 - crypto operation error.
         * @syscap SystemCapability.Security.CryptoFramework
         * @since 9
         */
        public fun generateRandomSync(len: Int): DataBlob

        /**
         * Indicates the random generation algorithm name.
         *
         * @type { string }
         * @readonly
         * @syscap SystemCapability.Security.CryptoFramework
         * @since 10
         */
        public val algName: String
    }

    public interface Md {

        /**
         * Update md with DataBlob.
         *
         * @param { DataBlob } input - indicates the DataBlob.
         * @returns { Promise<void> } the promise returned by the function.
         * @throws { BusinessError } 401 - invalid parameters.
         * @throws { BusinessError } 17630001 - crypto operation error.
         * @syscap SystemCapability.Security.CryptoFramework
         * @since 9
         */
        public fun update(input: DataBlob): Promise<Unit>

        /**
         * Output the result of md calculation.
         *
         * @returns { Promise<DataBlob> } the promise returned by the function.
         * @throws { BusinessError } 17620001 - memory error.
         * @throws { BusinessError } 17630001 - crypto operation error.
         * @syscap SystemCapability.Security.CryptoFramework
         * @since 9
         */
        public fun digest(): Promise<DataBlob>
        /**
         * Output the length of md result.
         *
         * @returns { number } returns the length of the hmac result.
         * @throws { BusinessError } 17630001 - crypto operation error.
         * @syscap SystemCapability.Security.CryptoFramework
         * @since 9
         */
        public fun getMdLength(): Int
        /**
         * Indicates the algorithm name.
         *
         * @type { string }
         * @readonly
         * @syscap SystemCapability.Security.CryptoFramework
         * @since 9
         */
        public val algName: String
    }

    public companion object {
        public fun createRandom(): Random

        public fun createMd(algName: String): Md
    }

}

internal suspend fun OhosCrypto.Md.digest(buffer: ByteArray): Uint8Array {
    val blob: OhosCrypto.DataBlob = js("{}")
    blob.data = Uint8Array(buffer.toTypedArray())
    update(blob).await()
    return digest().await().data
}
