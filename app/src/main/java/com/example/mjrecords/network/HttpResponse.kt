/*
 * Copyright (c) 2017 OpenLocate
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.example.mjrecords.network

import java.io.InputStream

class HttpResponse {
    var statusCode: Int = 0
        private set
    lateinit var error: Error
    lateinit var body: InputStream

    val isSuccess: Boolean
        get() = statusCode in STATUS_CODE_HTTP_OK..(STATUS_CODE_MULTIPLE_CHOICE - 1)

    private constructor(statusCode: Int, error: Error) {
        this.statusCode = statusCode
        this.error = error
    }

    private constructor(statusCode: Int, body: InputStream) {
        this.statusCode = statusCode
        this.body = body
    }

    internal class Builder {
        private var statusCode: Int = 0
        private var error: Error? = null
        private var body: InputStream? = null

        fun setStatusCode(statusCode: Int): Builder {
            this.statusCode = statusCode
            return this
        }

        fun setBody(body: InputStream): Builder {
            this.body = body
            return this
        }

        fun setError(error: Error): Builder {
            this.error = error
            return this
        }

        fun build(): HttpResponse {
            return if (body != null)
                HttpResponse(statusCode, body!!)
            else
                HttpResponse(statusCode, error!!)
        }
    }

    companion object {
        private val STATUS_CODE_HTTP_OK = 200
        private val STATUS_CODE_MULTIPLE_CHOICE = 300
    }
}
