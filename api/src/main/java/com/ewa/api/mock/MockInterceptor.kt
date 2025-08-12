package com.ewa.api.mock

import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException

class MockInterceptor(private val context: Context) : Interceptor {
    
    companion object {
        private const val BOOKS_JSON_FILE = "books.json"
        private val JSON_MEDIA_TYPE = "application/json".toMediaType()
    }
    
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val jsonResponse = readAssetFile(context, BOOKS_JSON_FILE)
        
        return Response.Builder()
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .code(200)
            .message("OK")
            .body(jsonResponse.toResponseBody(JSON_MEDIA_TYPE))
            .build()
    }

    fun readAssetFile(context: Context, fileName: String): String {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            throw RuntimeException("Failed to read asset file: $fileName", e)
        }
    }
}
