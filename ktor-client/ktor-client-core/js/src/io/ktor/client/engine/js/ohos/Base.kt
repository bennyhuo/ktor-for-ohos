package io.ktor.client.engine.js.ohos

/**
 * Created by Benny Huo on 2023/12/7
 */

/**
 * Defines the basic callback.
 * @typedef Callback
 * @syscap SystemCapability.Base
 * @since 6
 */
/**
 * Defines the basic callback.
 * @typedef Callback
 * @syscap SystemCapability.Base
 * @crossplatform
 * @since 10
 */
internal interface Callback<T> {
    /**
     * Defines the callback info.
     * @param { T } data
     * @syscap SystemCapability.Base
     * @since 6
     */
    /**
     * Defines the callback info.
     * @param { T } data
     * @syscap SystemCapability.Base
     * @crossplatform
     * @since 10
     */
    fun invoke(data: T)
}
/**
 * Defines the basic error callback.
 * @typedef ErrorCallback
 * @syscap SystemCapability.Base
 * @since 6
 */
/**
 * Defines the basic error callback.
 * @typedef ErrorCallback
 * @syscap SystemCapability.Base
 * @crossplatform
 * @since 10
 */
internal interface ErrorCallback<T : Error> {
    /**
     * Defines the basic error callback.
     * @param { T } err
     * @syscap SystemCapability.Base
     * @since 6
     */
    /**
     * Defines the basic error callback.
     * @param { T } err
     * @syscap SystemCapability.Base
     * @crossplatform
     * @since 10
     */
    fun invoke(err: T)
}
/**
 * Defines the basic async callback.
 * @typedef AsyncCallback
 * @syscap SystemCapability.Base
 * @since 6
 */
/**
 * Defines the basic async callback.
 * @typedef AsyncCallback
 * @syscap SystemCapability.Base
 * @crossplatform
 * @since 10
 */
internal interface AsyncCallback<T> {
    /**
     * Defines the callback data.
     * @param { BusinessError<E> } err
     * @param { T } data
     * @syscap SystemCapability.Base
     * @since 6
     */
    /**
     * Defines the callback data.
     * @param { BusinessError<E> } err
     * @param { T } data
     * @syscap SystemCapability.Base
     * @crossplatform
     * @since 10
     */
    fun invoke(err: BusinessError, data: T)
}
/**
 * Defines the error interface.
 * @typedef BusinessError
 * @syscap SystemCapability.Base
 * @since 6
 */
/**
 * Defines the error interface.
 * @typedef BusinessError
 * @syscap SystemCapability.Base
 * @crossplatform
 * @since 10
 */
internal abstract class BusinessError : Error() {
    /**
     * Defines the basic error code.
     * @type { number } code
     * @syscap SystemCapability.Base
     * @since 6
     */
    /**
     * Defines the basic error code.
     * @type { number } code
     * @syscap SystemCapability.Base
     * @crossplatform
     * @since 10
     */
    abstract val code: Int
    /**
     * Defines the additional information for business
     * @type { ?T } data
     * @syscap SystemCapability.Base
     * @since 9
     */
    /**
     * Defines the additional information for business
     * @type { ?T } data
     * @syscap SystemCapability.Base
     * @crossplatform
     * @since 10
     */
    abstract val data: Any?
}
