package com.igttestproject.stanislavkinzl.tabtest.app.database.remote.dependencyinjection

import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.ApiInterface
import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

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
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor,
                            httpApiInterceptor: ApiKeyInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(httpLoggingInterceptor)
        httpClient.addInterceptor(httpApiInterceptor)
        return httpClient.build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideHttpApiInterceptor(): ApiKeyInterceptor =
            ApiKeyInterceptor()
}