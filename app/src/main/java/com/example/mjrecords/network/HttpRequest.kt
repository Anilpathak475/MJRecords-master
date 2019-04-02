package com.example.mjrecords.network

class HttpRequest(var methodType: HttpMethodType, var url: String, var successCallback: HttpClientCallback, var failureCallback: HttpClientCallback) {

    val isValidForPost: Boolean
        get() = methodType == HttpMethodType.POST

    internal class Builder {
        private var methodType: HttpMethodType? = null
        private var url: String? = null
        private var params: String? = null
        private var additionalHeaders: Map<String, String>? = null
        private var successCallback: HttpClientCallback? = null
        private var failureCallback: HttpClientCallback? = null

        fun setMethodType(methodType: HttpMethodType): Builder {
            this.methodType = methodType
            return this
        }

        fun setUrl(url: String): Builder {
            this.url = url
            return this
        }

        fun setParams(params: String): Builder {
            this.params = params
            return this
        }

        fun setSuccessCallback(successCallback: HttpClientCallback): Builder {
            this.successCallback = successCallback
            return this
        }

        fun setFailureCallback(failureCallback: HttpClientCallback): Builder {
            this.failureCallback = failureCallback
            return this
        }

        fun setAdditionalHeaders(additionalHeaders: Map<String, String>): Builder {
            this.additionalHeaders = additionalHeaders
            return this
        }

        fun build(): HttpRequest {
            return HttpRequest(methodType!!, url!!, successCallback!!, failureCallback!!)
        }
    }

}
