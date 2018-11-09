package com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.injection.objects

import com.example.stanislavkinzl.tabtestupdateddep.testsAndroid.helpers.MockSettings
import okhttp3.*
import java.util.*

class OkHttpMockInterceptor : Interceptor {

    private val JSON = "application/json"

    override fun intercept(chain: Interceptor.Chain): Response {

        val path = chain.request().url().encodedPath().substring(1)

        val (code, jsonFile) = MockSettings.getEndpointResponse(path)
        val json = readFileAsString(jsonFile)

        return Response.Builder()
            .request(chain.request())
            .protocol(Protocol.HTTP_1_0)
            .code(code)
            .addHeader("content-type", JSON)
            .message("MOCK")
            .body(ResponseBody.create(MediaType.parse(JSON), json))
            .build()
    }

    private fun readFileAsString(fileName: String): String {
        val inputStream = this::class.java.classLoader.getResourceAsStream(fileName)
        val scanner = Scanner(inputStream).useDelimiter("\\A")
        return if (scanner.hasNext()) scanner.next() else ""
    }
}