package com.example.stanislavkinzl.tabtestupdateddep.injection.objects

import com.example.stanislavkinzl.tabtestupdateddep.helpers.AMockSettings
import okhttp3.*
import java.util.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class AOkHttpMockInterceptor : Interceptor {

    private val JSON = "application/json"

    override fun intercept(chain: Interceptor.Chain): Response {

        val path = chain.request().url().encodedPath().substring(1)

        val (code, jsonFile) = AMockSettings.getEndpointResponse(path)
        val json = readFileAsString(jsonFile)

        return Response.Builder()
            .request(chain.request())
            .protocol(Protocol.HTTP_1_0)
            .code(code)
            .addHeader("content-type", JSON)
            .message("MOCK")
            .body(ResponseBody.create(MediaType.parse(JSON), json)) //this line is faking it
            .build()
    }

    private fun readFileAsString(fileName: String): String {
        val inputStream = this::class.java.classLoader.getResourceAsStream(fileName)
        val scanner = Scanner(inputStream).useDelimiter("\\A")
        return if (scanner.hasNext()) scanner.next() else ""
    }
}