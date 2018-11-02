package com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.di

import android.arch.lifecycle.ViewModelProviders
import com.igttestproject.stanislavkinzl.tabtest.API_KEY
import com.igttestproject.stanislavkinzl.tabtest.PRIVATE_KEY
import com.igttestproject.stanislavkinzl.tabtest.extensions.md5
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.ApiInterface
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.ComicRepository
import com.igttestproject.stanislavkinzl.tabtest.mvp.repository.database.remote.ComicRepositoryImpl
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.MainActivity
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.ComicsListFragment
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.ComicsListPresenter
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicsViewModel
import com.igttestproject.stanislavkinzl.tabtest.mvp.representation.comicslist.model.ComicsViewModelFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


@Module
class ComicListPresenterModule {


    //============= MVVM/MVP =================


    @Provides
    fun provideComicsViewModel(mainActivity: MainActivity, memeViewModelFactory: ComicsViewModelFactory): ComicsViewModel =
            ViewModelProviders.of(mainActivity, memeViewModelFactory).get(ComicsViewModel::class.java)


    @Provides
    fun provideComicFragment(): ComicsListFragment =
            ComicsListFragment()

    @Provides
    fun provideComicRepository(comicRepository: ComicRepositoryImpl): ComicRepository =
            comicRepository

    @Provides
    fun provideComicsListPresenter(): ComicsListPresenter {
        return ComicsListPresenter()
    }

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
    fun provideBaseUrl(): String {
        return "http://gateway.marvel.com/v1/public/"
    }

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(httpLoggingInterceptor)//.build()
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
        return httpClient.build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}