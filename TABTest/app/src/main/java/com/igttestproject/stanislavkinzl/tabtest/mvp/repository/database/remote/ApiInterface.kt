package com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote

import io.reactivex.Single
import retrofit2.http.GET


interface ApiInterface {

    @GET(Endpoints.GET_COMICS)
    fun allComics(
            //@Query("offset") offset: Int? = COMICS_API_OFFSET
    ): Single<GetComicsResponse>
    // fun allComics(): Single<GetComicsResponse>

    object Endpoints {
        const val GET_COMICS = "comics"
    }
/*
    companion object {
        fun getService(): ApiInterface {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url()

                val ts = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
                val url = originalHttpUrl.newBuilder()
                        .addQueryParameter("apikey", API_KEY)
                        .addQueryParameter("ts", ts)
                        .addQueryParameter("hash", "$ts$PRIVATE_KEY$API_KEY".md5())
                        .build()

                chain.proceed(original.newBuilder().url(url).build())
            }

            val gson = GsonBuilder().setLenient().create()
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://gateway.marvel.com/v1/public/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build()

            return retrofit.create<ApiInterface>(ApiInterface::class.java)
        }
    }*/
}