package io.ktor.client.engine.js

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory

/**
 * Created by Benny Huo on 2023/12/8
 */
/**
 * A JavaScript client engine that uses the @ohos.net.http API to execute requests.
 *
 * To create the client with this engine, pass it to the `HttpClient` constructor:
 * ```kotlin
 * val client = HttpClient(Ohos)
 * ```
 * You can also call the [OhosClient] function to get the [Ohos] engine singleton:
 * ```kotlin
 * val client = OhosClient()
 * ```
 *
 * You can learn more about client engines from [Engines](https://ktor.io/docs/http-client-engines.html).
 */
public object Ohos : HttpClientEngineFactory<HttpClientEngineConfig> {
    override fun create(block: HttpClientEngineConfig.() -> Unit): HttpClientEngine =
        OhosJsClientEngine(OhosHttpClientEngineConfig().apply(block))
}

/**
 * Creates a [Ohos] client engine.
 */
@JsName("OhosClient")
public fun OhosClient(): HttpClientEngineFactory<HttpClientEngineConfig> = Ohos
