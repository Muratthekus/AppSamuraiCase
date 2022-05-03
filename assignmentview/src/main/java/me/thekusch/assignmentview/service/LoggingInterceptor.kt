package me.thekusch.assignmentview.service

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer

internal class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request: Request = chain.request()
        val t1 = System.currentTimeMillis()
        Log.d(
            "OkHttp", "Sending request ${request.url} \nrequest : ${bodyToString(request)}"
        )

        val response = chain.proceed(request)
        val t2 = System.currentTimeMillis()
        Log.d(
            "OkHttp",
            "Received response for ${response.request.url} in ${t2 - t1}ms  \n ${response.headers}",
            )

        return response
    }

    private fun bodyToString(request: Request): String? {
        return try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            copy.body?.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: Exception) {
            "did not work"
        }
    }

    companion object {
        const val TIME_OUT_DURATION = 10L
    }
}