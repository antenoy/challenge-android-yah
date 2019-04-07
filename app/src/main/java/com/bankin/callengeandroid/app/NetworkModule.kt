package com.bankin.callengeandroid.app

import android.content.Context
import com.bankin.callengeandroid.app.MainModule.Companion.APPLICATION
import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import timber.log.Timber
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/bankin-engineering/challenge-android/master/"
        private const val ONE_KB = 1024L
        private const val ONE_MB = ONE_KB * ONE_KB
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(
        cache: Cache,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient()
            .newBuilder()
            .cache(cache)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideCache(@Named(APPLICATION) context: Context): Cache =
        Cache(context.cacheDir, 4 * ONE_MB)

    @Provides
    fun provideLoggingInterceptor(timberTree: Timber.Tree): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { timberTree.d(it) })
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideRetrofit(
        mapper: ObjectMapper,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build()
    }
}