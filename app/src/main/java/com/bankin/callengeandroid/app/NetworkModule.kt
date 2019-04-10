package com.bankin.callengeandroid.app

import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/bankin-engineering/challenge-android/master/"
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    fun provideLoggingInterceptor(timberTree: Timber.Tree): HttpLoggingInterceptor =
        HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { timberTree.d(it) })
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideRetrofit(
        mapper: ObjectMapper,
        client: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build()
}