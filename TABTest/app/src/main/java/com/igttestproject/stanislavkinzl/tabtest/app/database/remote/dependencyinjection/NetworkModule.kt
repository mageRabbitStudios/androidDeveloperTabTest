package com.igttestproject.stanislavkinzl.tabtest.app.database.remote.dependencyinjection

import com.igttestproject.stanislavkinzl.tabtest.app.API_KEY
import com.igttestproject.stanislavkinzl.tabtest.app.PRIVATE_KEY
import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.ApiInterface
import com.igttestproject.stanislavkinzl.tabtest.app.extensions.md5
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

@Module
class NetworkModule {

    //============= RETROFIT ==============

    @Provides
    fun provideMarvelApi(retrofit: Retrofit): ApiInterface =
            retrofit.create(ApiInterface::class.java)

    @Provides
    fun provideRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()

    @Provides
    fun provideBaseUrl(): String = "http://gateway.marvel.com/v1/public/"

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, timestamp: Long): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(httpLoggingInterceptor)
        httpClient.addInterceptor { chain ->

            val originalHttpUrl = chain.request().url()

            val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("ts", timestamp.toString())
                    .addQueryParameter("hash", "$timestamp$PRIVATE_KEY$API_KEY".md5())
                    .build()

            chain.proceed(chain.request().newBuilder().url(url).build())
        }
        return httpClient.build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideTimestamp(): Long =
            Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000
}