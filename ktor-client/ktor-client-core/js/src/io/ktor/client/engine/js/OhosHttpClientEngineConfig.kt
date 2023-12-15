package io.ktor.client.engine.js

import io.ktor.client.engine.HttpClientEngineConfig

/**
 * Created by Benny Huo on 2023/12/7
 */
public class OhosHttpClientEngineConfig: HttpClientEngineConfig() {

    /**
     * Specifies a time period (in milliseconds) in which a client should establish a connection with a server.
     *
     * Set this value to `0` to use an infinite timeout.
     */
    public var connectTimeout: Int = 30_000

    /**
     * Specifies a maximum time (in milliseconds) of inactivity between two data packets when exchanging data with a server.
     *
     * Set this value to `0` to use an infinite timeout.
     */
    public var readTimeout: Int = 30_000

}
