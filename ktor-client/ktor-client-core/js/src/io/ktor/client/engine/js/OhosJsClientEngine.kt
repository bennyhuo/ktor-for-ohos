package io.ktor.client.engine.js

import com.kanyun.kotlin.ktor.ohos.api.Http
import io.ktor.client.engine.CLIENT_CONFIG
import io.ktor.client.engine.HttpClientEngineBase
import io.ktor.client.engine.callContext
import io.ktor.client.engine.mergeHeaders
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import io.ktor.client.utils.buildHeaders
import io.ktor.http.HttpProtocolVersion
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.OutgoingContent
import io.ktor.util.*
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.core.readBytes
import io.ktor.utils.io.core.toByteArray
import io.ktor.utils.io.writeFully
import io.ktor.utils.io.writer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Uint8Array

internal class OhosJsClientEngine(
    override val config: OhosHttpClientEngineConfig
) : HttpClientEngineBase("ktor-ohos") {

    @InternalAPI
    override suspend fun execute(data: HttpRequestData): HttpResponseData {
        val callContext = callContext()
        val clientConfig = data.attributes[CLIENT_CONFIG]

        val requestTime = GMTDate()
        val httpRequest = Http.createHttp()

        val options: Http.HttpRequestOptions = js("{}")
        options.apply {
            method = data.method.value

            val jsHeaders = js("({})")
            mergeHeaders(data.headers, data.body) { key, value ->
                jsHeaders[key] = value
            }
            header = jsHeaders

            val bodyBytes = when (val content = data.body) {
                is OutgoingContent.ByteArrayContent -> content.bytes()
                is OutgoingContent.ReadChannelContent -> content.readFrom().readRemaining().readBytes()
                is OutgoingContent.WriteChannelContent -> {
                    GlobalScope.writer(callContext) {
                        content.writeTo(channel)
                    }.channel.readRemaining().readBytes()
                }

                else -> null
            }
            bodyBytes?.let { extraData = Uint8Array(it.toTypedArray()) }

            connectTimeout = config.connectTimeout
            readTimeout = config.readTimeout
            usingProtocol = Http.HttpProtocol.HTTP1_1
            expectDataType = Http.HttpDataType.ARRAY_BUFFER
        }

        val response = httpRequest.request(data.url.toString(), options).await()

        val responseChannel = writer {
            when (val result = response.result as Any) {
                is String -> {
                    channel.writeFully(result.toByteArray())
                    channel.flush()
                }

                is ArrayBuffer -> {
                    val array = Uint8Array(result)
                    channel.writeFully(array.asByteArray())
                    channel.flush()
                }

                else -> {}
            }
        }.channel

        httpRequest.destroy()

        return HttpResponseData(
            HttpStatusCode(response.responseCode, ""),
            requestTime,
            buildHeaders {
                for (entry in js("Object").entries(response.header)) {
                    val key = entry[0]
                    val value = entry[1]
                    append(key, value)
                }
            },
            HttpProtocolVersion.HTTP_1_1,
            responseChannel,
            callContext
        )
    }
}
