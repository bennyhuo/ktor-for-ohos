package com.kanyun.kotlin.ktor.ohos.api

import io.ktor.client.engine.js.ohos.*
import io.ktor.client.fetch.ArrayBuffer
import kotlin.js.Promise

/**
 * Provides http related APIs.
 * @namespace http
 * @syscap SystemCapability.Communication.NetStack
 * @since 6
 */
/**
 * Provides http related APIs.
 * @namespace http
 * @syscap SystemCapability.Communication.NetStack
 * @crossplatform
 * @since 10
 */
@JsModule("@ohos.net.http")
internal external class Http {
    companion object {

        val HttpProtocol: _HttpProtocol

        val HttpDataType: _HttpDataType

        /**
         * Creates an HTTP request task.
         * @returns { HttpRequest } the HttpRequest of the createHttp.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Creates an HTTP request task.
         * @returns { HttpRequest } the HttpRequest of the createHttp.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun createHttp(): HttpRequest

        /**
         * Creates a default {@code HttpResponseCache} object to store the responses of HTTP access requests.
         * @param { number } cacheSize - the size of cache(max value is 10MB), default is 10*1024*1024(10MB).
         * @returns { HttpResponseCache } the HttpResponseCache of the createHttpResponseCache.
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * Creates a default {@code HttpResponseCache} object to store the responses of HTTP access requests.
         * @param { number } cacheSize - the size of cache(max value is 10MB), default is 10*1024*1024(10MB).
         * @returns { HttpResponseCache } the HttpResponseCache of the createHttpResponseCache.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun createHttpResponseCache(cacheSize: Int?): HttpResponseCache
    }

    /**
     * @syscap SystemCapability.Communication.NetStack
     * @since 10
     */
    interface HttpProxy {
        /**
         * Proxy server host name.
         * @type {string}
         * @syscap SystemCapability.Communication.NetManager.Core
         * @since 10
         */
        val host: String;
        /**
         * Host port.
         * @type {number}
         * @syscap SystemCapability.Communication.NetManager.Core
         * @since 10
         */
        val port: Int;
        /**
         * Do not use a blocking list for proxy servers.
         * @type {Array<string>}
         * @syscap SystemCapability.Communication.NetManager.Core
         * @since 10
         */
        val exclusionList: Array<String>;
    }

    /**
     * Specifies the type and value range of the optional parameters in the HTTP request.
     * @interface HttpRequestOptions
     * @syscap SystemCapability.Communication.NetStack
     * @since 6
     */
    /**
     * Specifies the type and value range of the optional parameters in the HTTP request.
     * @interface HttpRequestOptions
     * @syscap SystemCapability.Communication.NetStack
     * @crossplatform
     * @since 10
     */
    interface HttpRequestOptions {
        /**
         * Request method,default is GET.
         * @type {?RequestMethod}
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Request method,default is GET.
         * @type {?RequestMethod}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        var method: String?
        /**
         * Additional data of the request.
         * extraData can be a string or an Object (API 6) or an ArrayBuffer(API 8).
         * @type {?string | Object | ArrayBuffer}
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Additional data of the request.
         * extraData can be a string or an Object (API 6) or an ArrayBuffer(API 8).
         * @type {?string | Object | ArrayBuffer}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        var extraData: Any?
        /**
         * Data type to be returned. If this parameter is set, the system preferentially returns the specified type.
         * @type {?HttpDataType}
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * Data type to be returned. If this parameter is set, the system preferentially returns the specified type.
         * @type {?HttpDataType}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        var expectDataType: Int?
        /**
         * default is true
         * @type {?boolean}
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * default is true
         * @type {?boolean}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        var usingCache: Boolean?
        /**
         * [1, 1000], default is 1.
         * @type {?number}
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * [1, 1000], default is 1.
         * @type {?number}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        var priority: Int
        /**
         * HTTP request header. default is 'content-type': 'application/json'
         * @type {?Object}
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * HTTP request header. default is 'content-type': 'application/json'
         * @type {?Object}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        var header: Any?
        /**
         * Read timeout period. The default value is 60,000, in ms.
         * @type {?number}
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Read timeout period. The default value is 60,000, in ms.
         * @type {?number}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        var readTimeout: Int?
        /**
         * Connection timeout interval. The default value is 60,000, in ms.
         * @type {?number}
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Connection timeout interval. The default value is 60,000, in ms.
         * @type {?number}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        var connectTimeout: Int?;
        /**
         * default is automatically specified by the system.
         * @type {?HttpProtocol}
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * default is automatically specified by the system.
         * @type {?HttpProtocol}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        var usingProtocol: Int?
        /**
         * If this parameter is set as type of boolean, the system will use default proxy or not use proxy.
         * If this parameter is set as type of HttpProxy, the system will use the specified HttpProxy.
         * @type {?boolean | HttpProxy}
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        var usingProxy: Any?
        /**
         * If this parameter is set, the system will use ca path specified by user, or else use preset ca by the system.
         * @type {?string}
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        var caPath: String?
    }
    /**
     * <p>Defines an HTTP request task. Before invoking APIs provided by HttpRequest,
     * you must call createHttp() to create an HttpRequestTask object.</p>
     * @interface HttpRequest
     * @syscap SystemCapability.Communication.NetStack
     * @since 6
     */
    /**
     * <p>Defines an HTTP request task. Before invoking APIs provided by HttpRequest,
     * you must call createHttp() to create an HttpRequestTask object.</p>
     * @interface HttpRequest
     * @syscap SystemCapability.Communication.NetStack
     * @crossplatform
     * @since 10
     */
    interface HttpRequest {
        /**
         * Initiates an HTTP request to a given URL.
         * @permission ohos.permission.INTERNET
         * @param { string } url - URL for initiating an HTTP request.
         * @param { AsyncCallback<HttpResponse> } callback - the callback of request.
         * @throws { BusinessError } 401 - Parameter error.
         * @throws { BusinessError } 201 - Permission denied.
         * @throws { BusinessError } 2300001 - Unsupported protocol.
         * @throws { BusinessError } 2300003 - URL using bad/illegal format or missing URL.
         * @throws { BusinessError } 2300005 - Couldn't resolve proxy name.
         * @throws { BusinessError } 2300006 - Couldn't resolve host name.
         * @throws { BusinessError } 2300007 - Couldn't connect to server.
         * @throws { BusinessError } 2300008 - Weird server reply.
         * @throws { BusinessError } 2300009 - Access denied to remote resource.
         * @throws { BusinessError } 2300016 - Error in the HTTP2 framing layer.
         * @throws { BusinessError } 2300018 - Transferred a partial file.
         * @throws { BusinessError } 2300023 - Failed writing received data to disk/application.
         * @throws { BusinessError } 2300025 - Upload failed.
         * @throws { BusinessError } 2300026 - Failed to open/read local data from file/application.
         * @throws { BusinessError } 2300027 - Out of memory.
         * @throws { BusinessError } 2300028 - Timeout was reached.
         * @throws { BusinessError } 2300047 - Number of redirects hit maximum amount.
         * @throws { BusinessError } 2300052 - Server returned nothing (no headers, no data).
         * @throws { BusinessError } 2300055 - Failed sending data to the peer.
         * @throws { BusinessError } 2300056 - Failure when receiving data from the peer.
         * @throws { BusinessError } 2300058 - Problem with the local SSL certificate.
         * @throws { BusinessError } 2300059 - Couldn't use specified SSL cipher.
         * @throws { BusinessError } 2300060 - SSL peer certificate or SSH remote key was not OK.
         * @throws { BusinessError } 2300061 - Unrecognized or bad HTTP Content or Transfer-Encoding.
         * @throws { BusinessError } 2300063 - Maximum file size exceeded.
         * @throws { BusinessError } 2300070 - Disk full or allocation exceeded.
         * @throws { BusinessError } 2300073 - Remote file already exists.
         * @throws { BusinessError } 2300077 - Problem with the SSL CA cert (path? access rights?).
         * @throws { BusinessError } 2300078 - Remote file not found.
         * @throws { BusinessError } 2300094 - An authentication function returned an error.
         * @throws { BusinessError } 2300999 - Unknown Other Error.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Initiates an HTTP request to a given URL.
         * @permission ohos.permission.INTERNET
         * @param { string } url - URL for initiating an HTTP request.
         * @param { AsyncCallback<HttpResponse> } callback - the callback of request.
         * @throws { BusinessError } 401 - Parameter error.
         * @throws { BusinessError } 201 - Permission denied.
         * @throws { BusinessError } 2300001 - Unsupported protocol.
         * @throws { BusinessError } 2300003 - URL using bad/illegal format or missing URL.
         * @throws { BusinessError } 2300005 - Couldn't resolve proxy name.
         * @throws { BusinessError } 2300006 - Couldn't resolve host name.
         * @throws { BusinessError } 2300007 - Couldn't connect to server.
         * @throws { BusinessError } 2300008 - Weird server reply.
         * @throws { BusinessError } 2300009 - Access denied to remote resource.
         * @throws { BusinessError } 2300016 - Error in the HTTP2 framing layer.
         * @throws { BusinessError } 2300018 - Transferred a partial file.
         * @throws { BusinessError } 2300023 - Failed writing received data to disk/application.
         * @throws { BusinessError } 2300025 - Upload failed.
         * @throws { BusinessError } 2300026 - Failed to open/read local data from file/application.
         * @throws { BusinessError } 2300027 - Out of memory.
         * @throws { BusinessError } 2300028 - Timeout was reached.
         * @throws { BusinessError } 2300047 - Number of redirects hit maximum amount.
         * @throws { BusinessError } 2300052 - Server returned nothing (no headers, no data).
         * @throws { BusinessError } 2300055 - Failed sending data to the peer.
         * @throws { BusinessError } 2300056 - Failure when receiving data from the peer.
         * @throws { BusinessError } 2300058 - Problem with the local SSL certificate.
         * @throws { BusinessError } 2300059 - Couldn't use specified SSL cipher.
         * @throws { BusinessError } 2300060 - SSL peer certificate or SSH remote key was not OK.
         * @throws { BusinessError } 2300061 - Unrecognized or bad HTTP Content or Transfer-Encoding.
         * @throws { BusinessError } 2300063 - Maximum file size exceeded.
         * @throws { BusinessError } 2300070 - Disk full or allocation exceeded.
         * @throws { BusinessError } 2300073 - Remote file already exists.
         * @throws { BusinessError } 2300077 - Problem with the SSL CA cert (path? access rights?).
         * @throws { BusinessError } 2300078 - Remote file not found.
         * @throws { BusinessError } 2300094 - An authentication function returned an error.
         * @throws { BusinessError } 2300999 - Unknown Other Error.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun request(url: String, callback: AsyncCallback<HttpResponse>)
        /**
         * Initiates an HTTP request to a given URL.
         * @permission ohos.permission.INTERNET
         * @param { string } url - URL for initiating an HTTP request.
         * @param { HttpRequestOptions } options - Optional parameters {@link HttpRequestOptions}.
         * @param { AsyncCallback<HttpResponse> } callback - the callback of request..
         * @throws { BusinessError } 401 - Parameter error.
         * @throws { BusinessError } 201 - Permission denied.
         * @throws { BusinessError } 2300001 - Unsupported protocol.
         * @throws { BusinessError } 2300003 - URL using bad/illegal format or missing URL.
         * @throws { BusinessError } 2300005 - Couldn't resolve proxy name.
         * @throws { BusinessError } 2300006 - Couldn't resolve host name.
         * @throws { BusinessError } 2300007 - Couldn't connect to server.
         * @throws { BusinessError } 2300008 - Weird server reply.
         * @throws { BusinessError } 2300009 - Access denied to remote resource.
         * @throws { BusinessError } 2300016 - Error in the HTTP2 framing layer.
         * @throws { BusinessError } 2300018 - Transferred a partial file.
         * @throws { BusinessError } 2300023 - Failed writing received data to disk/application.
         * @throws { BusinessError } 2300025 - Upload failed.
         * @throws { BusinessError } 2300026 - Failed to open/read local data from file/application.
         * @throws { BusinessError } 2300027 - Out of memory.
         * @throws { BusinessError } 2300028 - Timeout was reached.
         * @throws { BusinessError } 2300047 - Number of redirects hit maximum amount.
         * @throws { BusinessError } 2300052 - Server returned nothing (no headers, no data).
         * @throws { BusinessError } 2300055 - Failed sending data to the peer.
         * @throws { BusinessError } 2300056 - Failure when receiving data from the peer.
         * @throws { BusinessError } 2300058 - Problem with the local SSL certificate.
         * @throws { BusinessError } 2300059 - Couldn't use specified SSL cipher.
         * @throws { BusinessError } 2300060 - SSL peer certificate or SSH remote key was not OK.
         * @throws { BusinessError } 2300061 - Unrecognized or bad HTTP Content or Transfer-Encoding.
         * @throws { BusinessError } 2300063 - Maximum file size exceeded.
         * @throws { BusinessError } 2300070 - Disk full or allocation exceeded.
         * @throws { BusinessError } 2300073 - Remote file already exists.
         * @throws { BusinessError } 2300077 - Problem with the SSL CA cert (path? access rights?).
         * @throws { BusinessError } 2300078 - Remote file not found.
         * @throws { BusinessError } 2300094 - An authentication function returned an error.
         * @throws { BusinessError } 2300999 - Unknown Other Error.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Initiates an HTTP request to a given URL.
         * @permission ohos.permission.INTERNET
         * @param { string } url - URL for initiating an HTTP request.
         * @param { HttpRequestOptions } options - Optional parameters {@link HttpRequestOptions}.
         * @param { AsyncCallback<HttpResponse> } callback - the callback of request.
         * @throws { BusinessError } 401 - Parameter error.
         * @throws { BusinessError } 201 - Permission denied.
         * @throws { BusinessError } 2300001 - Unsupported protocol.
         * @throws { BusinessError } 2300003 - URL using bad/illegal format or missing URL.
         * @throws { BusinessError } 2300005 - Couldn't resolve proxy name.
         * @throws { BusinessError } 2300006 - Couldn't resolve host name.
         * @throws { BusinessError } 2300007 - Couldn't connect to server.
         * @throws { BusinessError } 2300008 - Weird server reply.
         * @throws { BusinessError } 2300009 - Access denied to remote resource.
         * @throws { BusinessError } 2300016 - Error in the HTTP2 framing layer.
         * @throws { BusinessError } 2300018 - Transferred a partial file.
         * @throws { BusinessError } 2300023 - Failed writing received data to disk/application.
         * @throws { BusinessError } 2300025 - Upload failed.
         * @throws { BusinessError } 2300026 - Failed to open/read local data from file/application.
         * @throws { BusinessError } 2300027 - Out of memory.
         * @throws { BusinessError } 2300028 - Timeout was reached.
         * @throws { BusinessError } 2300047 - Number of redirects hit maximum amount.
         * @throws { BusinessError } 2300052 - Server returned nothing (no headers, no data).
         * @throws { BusinessError } 2300055 - Failed sending data to the peer.
         * @throws { BusinessError } 2300056 - Failure when receiving data from the peer.
         * @throws { BusinessError } 2300058 - Problem with the local SSL certificate.
         * @throws { BusinessError } 2300059 - Couldn't use specified SSL cipher.
         * @throws { BusinessError } 2300060 - SSL peer certificate or SSH remote key was not OK.
         * @throws { BusinessError } 2300061 - Unrecognized or bad HTTP Content or Transfer-Encoding.
         * @throws { BusinessError } 2300063 - Maximum file size exceeded.
         * @throws { BusinessError } 2300070 - Disk full or allocation exceeded.
         * @throws { BusinessError } 2300073 - Remote file already exists.
         * @throws { BusinessError } 2300077 - Problem with the SSL CA cert (path? access rights?).
         * @throws { BusinessError } 2300078 - Remote file not found.
         * @throws { BusinessError } 2300094 - An authentication function returned an error.
         * @throws { BusinessError } 2300999 - Unknown Other Error.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun request(url: String, options: HttpRequestOptions, callback: AsyncCallback<HttpResponse>)
        /**
         * Initiates an HTTP request to a given URL.
         * @permission ohos.permission.INTERNET
         * @param { string } url - URL for initiating an HTTP request.
         * @param { HttpRequestOptions } options - Optional parameters {@link HttpRequestOptions}.
         * @returns { Promise<HttpResponse> } The promise returned by the function.
         * @throws { BusinessError } 401 - Parameter error.
         * @throws { BusinessError } 201 - Permission denied.
         * @throws { BusinessError } 2300001 - Unsupported protocol.
         * @throws { BusinessError } 2300003 - URL using bad/illegal format or missing URL.
         * @throws { BusinessError } 2300005 - Couldn't resolve proxy name.
         * @throws { BusinessError } 2300006 - Couldn't resolve host name.
         * @throws { BusinessError } 2300007 - Couldn't connect to server.
         * @throws { BusinessError } 2300008 - Weird server reply.
         * @throws { BusinessError } 2300009 - Access denied to remote resource.
         * @throws { BusinessError } 2300016 - Error in the HTTP2 framing layer.
         * @throws { BusinessError } 2300018 - Transferred a partial file.
         * @throws { BusinessError } 2300023 - Failed writing received data to disk/application.
         * @throws { BusinessError } 2300025 - Upload failed.
         * @throws { BusinessError } 2300026 - Failed to open/read local data from file/application.
         * @throws { BusinessError } 2300027 - Out of memory.
         * @throws { BusinessError } 2300028 - Timeout was reached.
         * @throws { BusinessError } 2300047 - Number of redirects hit maximum amount.
         * @throws { BusinessError } 2300052 - Server returned nothing (no headers, no data).
         * @throws { BusinessError } 2300055 - Failed sending data to the peer.
         * @throws { BusinessError } 2300056 - Failure when receiving data from the peer.
         * @throws { BusinessError } 2300058 - Problem with the local SSL certificate.
         * @throws { BusinessError } 2300059 - Couldn't use specified SSL cipher.
         * @throws { BusinessError } 2300060 - SSL peer certificate or SSH remote key was not OK.
         * @throws { BusinessError } 2300061 - Unrecognized or bad HTTP Content or Transfer-Encoding.
         * @throws { BusinessError } 2300063 - Maximum file size exceeded.
         * @throws { BusinessError } 2300070 - Disk full or allocation exceeded.
         * @throws { BusinessError } 2300073 - Remote file already exists.
         * @throws { BusinessError } 2300077 - Problem with the SSL CA cert (path? access rights?).
         * @throws { BusinessError } 2300078 - Remote file not found.
         * @throws { BusinessError } 2300094 - An authentication function returned an error.
         * @throws { BusinessError } 2300999 - Unknown Other Error.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Initiates an HTTP request to a given URL.
         * @permission ohos.permission.INTERNET
         * @param { string } url - URL for initiating an HTTP request.
         * @param { HttpRequestOptions } options - Optional parameters {@link HttpRequestOptions}.
         * @returns { Promise<HttpResponse> } The promise returned by the function.
         * @throws { BusinessError } 401 - Parameter error.
         * @throws { BusinessError } 201 - Permission denied.
         * @throws { BusinessError } 2300001 - Unsupported protocol.
         * @throws { BusinessError } 2300003 - URL using bad/illegal format or missing URL.
         * @throws { BusinessError } 2300005 - Couldn't resolve proxy name.
         * @throws { BusinessError } 2300006 - Couldn't resolve host name.
         * @throws { BusinessError } 2300007 - Couldn't connect to server.
         * @throws { BusinessError } 2300008 - Weird server reply.
         * @throws { BusinessError } 2300009 - Access denied to remote resource.
         * @throws { BusinessError } 2300016 - Error in the HTTP2 framing layer.
         * @throws { BusinessError } 2300018 - Transferred a partial file.
         * @throws { BusinessError } 2300023 - Failed writing received data to disk/application.
         * @throws { BusinessError } 2300025 - Upload failed.
         * @throws { BusinessError } 2300026 - Failed to open/read local data from file/application.
         * @throws { BusinessError } 2300027 - Out of memory.
         * @throws { BusinessError } 2300028 - Timeout was reached.
         * @throws { BusinessError } 2300047 - Number of redirects hit maximum amount.
         * @throws { BusinessError } 2300052 - Server returned nothing (no headers, no data).
         * @throws { BusinessError } 2300055 - Failed sending data to the peer.
         * @throws { BusinessError } 2300056 - Failure when receiving data from the peer.
         * @throws { BusinessError } 2300058 - Problem with the local SSL certificate.
         * @throws { BusinessError } 2300059 - Couldn't use specified SSL cipher.
         * @throws { BusinessError } 2300060 - SSL peer certificate or SSH remote key was not OK.
         * @throws { BusinessError } 2300061 - Unrecognized or bad HTTP Content or Transfer-Encoding.
         * @throws { BusinessError } 2300063 - Maximum file size exceeded.
         * @throws { BusinessError } 2300070 - Disk full or allocation exceeded.
         * @throws { BusinessError } 2300073 - Remote file already exists.
         * @throws { BusinessError } 2300077 - Problem with the SSL CA cert (path? access rights?).
         * @throws { BusinessError } 2300078 - Remote file not found.
         * @throws { BusinessError } 2300094 - An authentication function returned an error.
         * @throws { BusinessError } 2300999 - Unknown Other Error.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun request(url: String, options: HttpRequestOptions?): Promise<HttpResponse>;
        /**
         * Initiates an HTTP request to a given URL, applicable to scenarios where http response supports streaming.
         * @permission ohos.permission.INTERNET
         * @param { string } url - URL for initiating an HTTP request.
         * @param { AsyncCallback<number> } callback - Returns the callback of requestInStream {@link ResponseCode},
         * should use on_headersReceive and on_dataReceive to get http response.
         * @throws { BusinessError } 401 - Parameter error.
         * @throws { BusinessError } 201 - Permission denied.
         * @throws { BusinessError } 2300001 - Unsupported protocol.
         * @throws { BusinessError } 2300003 - URL using bad/illegal format or missing URL.
         * @throws { BusinessError } 2300005 - Couldn't resolve proxy name.
         * @throws { BusinessError } 2300006 - Couldn't resolve host name.
         * @throws { BusinessError } 2300007 - Couldn't connect to server.
         * @throws { BusinessError } 2300008 - Weird server reply.
         * @throws { BusinessError } 2300009 - Access denied to remote resource.
         * @throws { BusinessError } 2300016 - Error in the HTTP2 framing layer.
         * @throws { BusinessError } 2300018 - Transferred a partial file.
         * @throws { BusinessError } 2300023 - Failed writing received data to disk/application.
         * @throws { BusinessError } 2300025 - Upload failed.
         * @throws { BusinessError } 2300026 - Failed to open/read local data from file/application.
         * @throws { BusinessError } 2300027 - Out of memory.
         * @throws { BusinessError } 2300028 - Timeout was reached.
         * @throws { BusinessError } 2300047 - Number of redirects hit maximum amount.
         * @throws { BusinessError } 2300052 - Server returned nothing (no headers, no data).
         * @throws { BusinessError } 2300055 - Failed sending data to the peer.
         * @throws { BusinessError } 2300056 - Failure when receiving data from the peer.
         * @throws { BusinessError } 2300058 - Problem with the local SSL certificate.
         * @throws { BusinessError } 2300059 - Couldn't use specified SSL cipher.
         * @throws { BusinessError } 2300060 - SSL peer certificate or SSH remote key was not OK.
         * @throws { BusinessError } 2300061 - Unrecognized or bad HTTP Content or Transfer-Encoding.
         * @throws { BusinessError } 2300063 - Maximum file size exceeded.
         * @throws { BusinessError } 2300070 - Disk full or allocation exceeded.
         * @throws { BusinessError } 2300073 - Remote file already exists.
         * @throws { BusinessError } 2300077 - Problem with the SSL CA cert (path? access rights?).
         * @throws { BusinessError } 2300078 - Remote file not found.
         * @throws { BusinessError } 2300094 - An authentication function returned an error.
         * @throws { BusinessError } 2300999 - Unknown Other Error.
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        fun requestInStream(url: String, callback: AsyncCallback<Int>)
        /**
         * Initiates an HTTP request to a given URL, applicable to scenarios where http response supports streaming.
         * @permission ohos.permission.INTERNET
         * @param { string } url - URL for initiating an HTTP request.
         * @param { HttpRequestOptions } options - Optional parameters {@link HttpRequestOptions}.
         * @param { AsyncCallback<number> } callback - the callback of requestInStream.
         * @throws { BusinessError } 401 - Parameter error.
         * @throws { BusinessError } 201 - Permission denied.
         * @throws { BusinessError } 2300001 - Unsupported protocol.
         * @throws { BusinessError } 2300003 - URL using bad/illegal format or missing URL.
         * @throws { BusinessError } 2300005 - Couldn't resolve proxy name.
         * @throws { BusinessError } 2300006 - Couldn't resolve host name.
         * @throws { BusinessError } 2300007 - Couldn't connect to server.
         * @throws { BusinessError } 2300008 - Weird server reply.
         * @throws { BusinessError } 2300009 - Access denied to remote resource.
         * @throws { BusinessError } 2300016 - Error in the HTTP2 framing layer.
         * @throws { BusinessError } 2300018 - Transferred a partial file.
         * @throws { BusinessError } 2300023 - Failed writing received data to disk/application.
         * @throws { BusinessError } 2300025 - Upload failed.
         * @throws { BusinessError } 2300026 - Failed to open/read local data from file/application.
         * @throws { BusinessError } 2300027 - Out of memory.
         * @throws { BusinessError } 2300028 - Timeout was reached.
         * @throws { BusinessError } 2300047 - Number of redirects hit maximum amount.
         * @throws { BusinessError } 2300052 - Server returned nothing (no headers, no data).
         * @throws { BusinessError } 2300055 - Failed sending data to the peer.
         * @throws { BusinessError } 2300056 - Failure when receiving data from the peer.
         * @throws { BusinessError } 2300058 - Problem with the local SSL certificate.
         * @throws { BusinessError } 2300059 - Couldn't use specified SSL cipher.
         * @throws { BusinessError } 2300060 - SSL peer certificate or SSH remote key was not OK.
         * @throws { BusinessError } 2300061 - Unrecognized or bad HTTP Content or Transfer-Encoding.
         * @throws { BusinessError } 2300063 - Maximum file size exceeded.
         * @throws { BusinessError } 2300070 - Disk full or allocation exceeded.
         * @throws { BusinessError } 2300073 - Remote file already exists.
         * @throws { BusinessError } 2300077 - Problem with the SSL CA cert (path? access rights?).
         * @throws { BusinessError } 2300078 - Remote file not found.
         * @throws { BusinessError } 2300094 - An authentication function returned an error.
         * @throws { BusinessError } 2300999 - Unknown Other Error.
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        fun requestInStream(url: String, options: HttpRequestOptions, callback: AsyncCallback<Int>)
        /**
         * Initiates an HTTP request to a given URL, applicable to scenarios where http response supports streaming.
         * @permission ohos.permission.INTERNET
         * @param { string } url - URL for initiating an HTTP request.
         * @param { HttpRequestOptions } options - Optional parameters {@link HttpRequestOptions}.
         * @returns { Promise<number> } the promise returned by the function.
         * @throws { BusinessError } 401 - Parameter error.
         * @throws { BusinessError } 201 - Permission denied.
         * @throws { BusinessError } 2300001 - Unsupported protocol.
         * @throws { BusinessError } 2300003 - URL using bad/illegal format or missing URL.
         * @throws { BusinessError } 2300005 - Couldn't resolve proxy name.
         * @throws { BusinessError } 2300006 - Couldn't resolve host name.
         * @throws { BusinessError } 2300007 - Couldn't connect to server.
         * @throws { BusinessError } 2300008 - Weird server reply.
         * @throws { BusinessError } 2300009 - Access denied to remote resource.
         * @throws { BusinessError } 2300016 - Error in the HTTP2 framing layer.
         * @throws { BusinessError } 2300018 - Transferred a partial file.
         * @throws { BusinessError } 2300023 - Failed writing received data to disk/application.
         * @throws { BusinessError } 2300025 - Upload failed.
         * @throws { BusinessError } 2300026 - Failed to open/read local data from file/application.
         * @throws { BusinessError } 2300027 - Out of memory.
         * @throws { BusinessError } 2300028 - Timeout was reached.
         * @throws { BusinessError } 2300047 - Number of redirects hit maximum amount.
         * @throws { BusinessError } 2300052 - Server returned nothing (no headers, no data).
         * @throws { BusinessError } 2300055 - Failed sending data to the peer.
         * @throws { BusinessError } 2300056 - Failure when receiving data from the peer.
         * @throws { BusinessError } 2300058 - Problem with the local SSL certificate.
         * @throws { BusinessError } 2300059 - Couldn't use specified SSL cipher.
         * @throws { BusinessError } 2300060 - SSL peer certificate or SSH remote key was not OK.
         * @throws { BusinessError } 2300061 - Unrecognized or bad HTTP Content or Transfer-Encoding.
         * @throws { BusinessError } 2300063 - Maximum file size exceeded.
         * @throws { BusinessError } 2300070 - Disk full or allocation exceeded.
         * @throws { BusinessError } 2300073 - Remote file already exists.
         * @throws { BusinessError } 2300077 - Problem with the SSL CA cert (path? access rights?).
         * @throws { BusinessError } 2300078 - Remote file not found.
         * @throws { BusinessError } 2300094 - An authentication function returned an error.
         * @throws { BusinessError } 2300999 - Unknown Other Error.
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        fun requestInStream(url: String, options: HttpRequestOptions?): Promise<Int>
        /**
         * Destroys an HTTP request.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Destroys an HTTP request.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun destroy()
        /**
         * Registers an observer for HTTP Response Header events.
         * @param { "headerReceive" } type - Indicates Event name.
         * @param { AsyncCallback<Object> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         * @deprecated since 8
         * @useinstead on_headersReceive
         */
        fun on(type: String /* "headerReceive" */, callback: AsyncCallback<Any>)
        /**
         * Unregisters the observer for HTTP Response Header events.
         * @param { "headerReceive" } type - Indicates Event name.
         * @param { AsyncCallback<Object> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         * @deprecated since 8
         * @useinstead off_headersReceive
         */
        fun off(type: String /* "headerReceive" */, callback: AsyncCallback<Any>?)
        /**
         * Registers an observer for HTTP Response Header events.
         * @param { "headersReceive" } type - Indicates Event name.
         * @param { Callback<Object> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 8
         */
        /**
         * Registers an observer for HTTP Response Header events.
         * @param { "headersReceive" } type - Indicates Event name.
         * @param { Callback<Object> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun on(type: String /* "headersReceive" */, callback: Callback<Any>)
        /**
         * Unregisters the observer for HTTP Response Header events.
         * @param { "headersReceive" } type - Indicates Event name.
         * @param { Callback<Object> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 8
         */
        /**
         * Unregisters the observer for HTTP Response Header events.
         * @param { "headersReceive" } type - Indicates Event name.
         * @param { Callback<Object> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun off(type: String /* "headersReceive" */, callback: Callback<Any>?)
        /**
         * Registers a one-time observer for HTTP Response Header events.
         * @param { "headersReceive" } type - Indicates Event name.
         * @param { Callback<Object> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 8
         */
        /**
         * Registers a one-time observer for HTTP Response Header events.
         * @param { "headersReceive" } type - Indicates Event name.
         * @param { Callback<Object> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun once(type: String /* "headersReceive" */, callback: Callback<Any>)
        /**
         * Registers an observer for receiving HTTP Response data events continuously.
         * @param { "dataReceive" } type - Indicates Event name.
         * @param { Callback<ArrayBuffer> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        fun on(type: String /* "dataReceive" */, callback: Callback<ArrayBuffer>)
        /**
         * Unregisters an observer for receiving HTTP Response data events continuously.
         * @param { "dataReceive" } type - Indicates Event name.
         * @param { Callback<ArrayBuffer> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        fun off(type: String /* "dataReceive" */, callback: Callback<ArrayBuffer>?)
        /**
         * Registers an observer for receiving HTTP Response data ends events.
         * @param { "dataEnd" } type - Indicates Event name.
         * @param { Callback<void> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        fun on(type: String /* "dataEnd" */, callback: Callback<Unit>)
        /**
         * Unregisters an observer for receiving HTTP Response data ends events.
         * @param { "dataEnd" } type - Indicates Event name.
         * @param { Callback<void> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        fun off(type: String /* "dataEnd" */, callback: Callback<Unit>?)
        /**
         * Registers an observer for progress of receiving HTTP Response data events.
         * @param { 'dataReceiveProgress' } type - Indicates Event name.
         * @param { Callback<{ receiveSize: number, totalSize: number }> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        fun on(type: String /* 'dataReceiveProgress' */, callback: Callback<DataProgress>)
        /**
         * Unregisters an observer for progress of receiving HTTP Response data events.
         * @param { 'dataReceiveProgress' } type - Indicates Event name.
         * @param { Callback<{ receiveSize: number, totalSize: number }> } callback - the callback used to return the result.
         * @syscap SystemCapability.Communication.NetStack
         * @since 10
         */
        fun off(type: String /* 'dataReceiveProgress' */, callback: Callback<DataProgress>?)

        interface DataProgress {
            val receiveSize: Int
            val totalSize: Int
        }
    }
    /**
     * Defines an HTTP request method.
     * @enum {string}
     * @syscap SystemCapability.Communication.NetStack
     * @since 6
     */
    /**
     * Defines an HTTP request method.
     * @enum {string}
     * @syscap SystemCapability.Communication.NetStack
     * @crossplatform
     * @since 10
     */
    object RequestMethod {
        /**
         * OPTIONS method.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * OPTIONS method.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val OPTIONS: String
        /**
         * GET method.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * GET method.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val GET: String
        /**
         * HEAD method.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * HEAD method.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val HEAD: String
        /**
         * POST method.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * POST method.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val POST: String
        /**
         * PUT method.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * PUT method.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val PUT: String
        /**
         * DELETE method.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * DELETE method.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val DELETE: String
        /**
         * TRACE method.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * TRACE method.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val TRACE: String
        /**
         * CONNECT method.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * CONNECT method.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val CONNECT: String
    }
    /**
     * Enumerates the response codes for an HTTP request.
     * @enum {number}
     * @syscap SystemCapability.Communication.NetStack
     * @since 6
     */
    /**
     * Enumerates the response codes for an HTTP request.
     * @enum {number}
     * @syscap SystemCapability.Communication.NetStack
     * @crossplatform
     * @since 10
     */
    object ResponseCode {
        /**
         * The request was successful. Typically used for GET and POST requests.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The request was successful. Typically used for GET and POST requests.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val OK: Int = definedExternally
        /**
         * Successfully requested and created a new resource.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Successfully requested and created a new resource.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val CREATED: Int = definedExternally
        /**
         * The request has been accepted but has not been processed completely.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The request has been accepted but has not been processed completely.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val ACCEPTED: Int = definedExternally
        /**
         * Unauthorized information. The request was successful.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Unauthorized information. The request was successful.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val NOT_AUTHORITATIVE: Int = definedExternally
        /**
         * No content. The server successfully processed, but did not return content.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * No content. The server successfully processed, but did not return content.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val NO_CONTENT: Int = definedExternally
        /**
         * Reset the content.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Reset the content.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val RESET: Int = definedExternally
        /**
         * Partial content. The server successfully processed some GET requests.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Partial content. The server successfully processed some GET requests.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val PARTIAL: Int = definedExternally
        /**
         * Multiple options.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Multiple options.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val MULT_CHOICE: Int = definedExternally
        /**
         * <p>Permanently move. The requested resource has been permanently moved to a new URI,
         * and the returned information will include the new URI. The browser will automatically redirect to the new URI.</p>
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * <p>Permanently move. The requested resource has been permanently moved to a new URI,
         * and the returned information will include the new URI. The browser will automatically redirect to the new URI.</p>
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val MOVED_PERM: Int = definedExternally
        /**
         * Temporary movement.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Temporary movement.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val MOVED_TEMP: Int = definedExternally
        /**
         * View other addresses.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * View other addresses.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val SEE_OTHER: Int = definedExternally
        /**
         * Not modified.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Not modified.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val NOT_MODIFIED: Int = definedExternally
        /**
         * Using proxies.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Using proxies.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val USE_PROXY: Int = definedExternally
        /**
         * The server cannot understand the syntax error error requested by the client.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The server cannot understand the syntax error error requested by the client.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val BAD_REQUEST: Int = definedExternally
        /**
         * Request for user authentication.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Request for user authentication.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val UNAUTHORIZED: Int
        /**
         * Reserved for future use.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Reserved for future use.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val PAYMENT_REQUIRED: Int
        /**
         * The server understands the request from the requesting client, but refuses to execute it.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The server understands the request from the requesting client, but refuses to execute it.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val FORBIDDEN: Int
        /**
         * The server was unable to find resources (web pages) based on the client's request.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The server was unable to find resources (web pages) based on the client's request.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val NOT_FOUND: Int
        /**
         * The method in the client request is prohibited.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The method in the client request is prohibited.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val BAD_METHOD: Int
        /**
         * The server is unable to complete the request based on the content characteristics requested by the client.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The server is unable to complete the request based on the content characteristics requested by the client.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val NOT_ACCEPTABLE: Int
        /**
         * Request authentication of the proxy's identity.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Request authentication of the proxy's identity.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val PROXY_AUTH: Int
        /**
         * The request took too long and timed out.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The request took too long and timed out.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val CLIENT_TIMEOUT: Int
        /**
         * <p>The server may have returned this code when completing the client's PUT request,
         * as there was a conflict when the server was processing the request.</p>
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * <p>The server may have returned this code when completing the client's PUT request,
         * as there was a conflict when the server was processing the request.</p>
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val CONFLICT: Int
        /**
         * The resource requested by the client no longer exists.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The resource requested by the client no longer exists.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val GONE: Int
        /**
         * The server is unable to process request information sent by the client without Content Length.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The server is unable to process request information sent by the client without Content Length.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val LENGTH_REQUIRED: Int
        /**
         * The prerequisite for requesting information from the client is incorrect.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The prerequisite for requesting information from the client is incorrect.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val PRECON_FAILED: Int
        /**
         * The request was rejected because the requested entity was too large for the server to process.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The request was rejected because the requested entity was too large for the server to process.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val ENTITY_TOO_LARGE: Int
        /**
         * The requested URI is too long (usually a URL) and the server cannot process it.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The requested URI is too long (usually a URL) and the server cannot process it.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val REQ_TOO_LONG: Int
        /**
         * The server is unable to process the requested format.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The server is unable to process the requested format.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val UNSUPPORTED_TYPE: Int
        /**
         * Internal server error, unable to complete the request.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Internal server error, unable to complete the request.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val INTERNAL_ERROR: Int
        /**
         * The server does not support the requested functionality and cannot complete the request.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The server does not support the requested functionality and cannot complete the request.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val NOT_IMPLEMENTED: Int
        /**
         * The server acting as a gateway or proxy received an invalid request from the remote server.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The server acting as a gateway or proxy received an invalid request from the remote server.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val BAD_GATEWAY: Int
        /**
         * Due to overload or system maintenance, the server is temporarily unable to process client requests.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Due to overload or system maintenance, the server is temporarily unable to process client requests.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val UNAVAILABLE: Int
        /**
         * The server acting as a gateway or proxy did not obtain requests from the remote server in a timely manner.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The server acting as a gateway or proxy did not obtain requests from the remote server in a timely manner.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val GATEWAY_TIMEOUT: Int
        /**
         * The version of the HTTP protocol requested by the server.
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * The version of the HTTP protocol requested by the server.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val VERSION: Int
    }
    /**
     * Supported protocols.
     * @enum {string}
     * @syscap SystemCapability.Communication.NetStack
     * @since 9
     */
    /**
     * Supported protocols.
     * @enum {string}
     * @syscap SystemCapability.Communication.NetStack
     * @crossplatform
     * @since 10
     */
    class _HttpProtocol {
        /**
         * Protocol http1.1
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * Protocol http1.1
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val HTTP1_1: Int = definedExternally
        /**
         * Protocol http2
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * Protocol http2
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val HTTP2: Int = definedExternally
    }

    /**
     * Indicates the type of the returned data.
     * @enum {number}
     * @syscap SystemCapability.Communication.NetStack
     * @since 9
     */
    /**
     * Indicates the type of the returned data.
     * @enum {number}
     * @syscap SystemCapability.Communication.NetStack
     * @crossplatform
     * @since 10
     */
    object _HttpDataType {
        /**
         * The returned type is string.
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * The returned type is string.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val STRING: Int = definedExternally
        /**
         * The returned type is Object.
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * The returned type is Object.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val OBJECT: Int = definedExternally
        /**
         * The returned type is ArrayBuffer.
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * The returned type is ArrayBuffer.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val ARRAY_BUFFER: Int = definedExternally
    }

    /**
     * Defines the response to an HTTP request.
     * @interface HttpResponse
     * @syscap SystemCapability.Communication.NetStack
     * @since 6
     */
    /**
     * Defines the response to an HTTP request.
     * @interface HttpResponse
     * @syscap SystemCapability.Communication.NetStack
     * @crossplatform
     * @since 10
     */
    interface HttpResponse {
        /**
         * result can be a string (API 6) or an ArrayBuffer(API 8). Object is deprecated from API 8.
         * If {@link HttpRequestOptions#expectDataType} is set, the system preferentially returns this parameter.
         * @type {string | Object | ArrayBuffer}
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * result can be a string (API 6) or an ArrayBuffer(API 8). Object is deprecated from API 8.
         * If {@link HttpRequestOptions#expectDataType} is set, the system preferentially returns this parameter.
         * @type {string | Object | ArrayBuffer}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val result: dynamic
        /**
         * If the resultType is string, you can get result directly.
         * If the resultType is Object, you can get result such as this: result['key'].
         * If the resultType is ArrayBuffer, you can use ArrayBuffer to create the binary objects.
         * @type {HttpDataType}
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * If the resultType is string, you can get result directly.
         * If the resultType is Object, you can get result such as this: result['key'].
         * If the resultType is ArrayBuffer, you can use ArrayBuffer to create the binary objects.
         * @type {HttpDataType}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val resultType: _HttpDataType
        /**
         * Server status code.
         * @type {ResponseCode | number}
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * Server status code.
         * @type {ResponseCode | number}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val responseCode: Int
        /**
         * All headers in the response from the server.
         * @type {Object}
         * @syscap SystemCapability.Communication.NetStack
         * @since 6
         */
        /**
         * All headers in the response from the server.
         * @type {Object}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val header: Any
        /**
         * Cookies returned by the server.
         * @type {string}
         * @syscap SystemCapability.Communication.NetStack
         * @since 8
         */
        /**
         * Cookies returned by the server.
         * @type {string}
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        val cookies: String
    }

    /**
     * Defines an object that stores the response to an HTTP request.
     * @interface HttpResponseCache
     * @syscap SystemCapability.Communication.NetStack
     * @since 9
     */
    /**
     * Defines an object that stores the response to an HTTP request.
     * @interface HttpResponseCache
     * @syscap SystemCapability.Communication.NetStack
     * @crossplatform
     * @since 10
     */
    interface HttpResponseCache {
        /**
         * Writes data in the cache to the file system so that all the cached data can be accessed in the next HTTP request.
         * @param { AsyncCallback<void> } callback - the callback of flush.
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * Writes data in the cache to the file system so that all the cached data can be accessed in the next HTTP request.
         * @param { AsyncCallback<void> } callback - the callback of flush.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun flush(callback: AsyncCallback<Unit>)
        /**
         * Writes data in the cache to the file system so that all the cached data can be accessed in the next HTTP request.
         * @returns { Promise<void> } The promise returned by the flush.
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * Writes data in the cache to the file system so that all the cached data can be accessed in the next HTTP request.
         * @returns { Promise<void> } The promise returned by the flush.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun flush(): Promise<Unit>
        /**
         * Disables a cache and deletes the data in it.
         * @param { AsyncCallback<void> } callback - the callback of delete.
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * Disables a cache and deletes the data in it.
         * @param { AsyncCallback<void> } callback - the callback of delete.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun delete(callback: AsyncCallback<Unit>)
        /**
         * Disables a cache and deletes the data in it.
         * @returns { Promise<void> } The promise returned by the delete.
         * @syscap SystemCapability.Communication.NetStack
         * @since 9
         */
        /**
         * Disables a cache and deletes the data in it.
         * @returns { Promise<void> } The promise returned by the delete.
         * @syscap SystemCapability.Communication.NetStack
         * @crossplatform
         * @since 10
         */
        fun delete(): Promise<Unit>
    }
}
