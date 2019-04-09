package com.bankin.callengeandroid.app

import android.content.Context
import android.content.res.Resources
import com.challenge.mob.core.repository.MainCategoryRepository
import com.challenge.mob.core.repository.SubCategoryRepository
import com.challenge.mob.repository.ChallengeServices
import com.challenge.mob.repository.local.createCategoriesDataProvider
import com.challenge.mob.repository.maincategory.MainCategoryRepositoryImpl
import com.challenge.mob.repository.subcategory.SubCategoryRepositoryImpl
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import timber.log.Timber
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Named
import javax.inject.Singleton

@Module
class MainModule(val context: Context) {
    companion object {
        const val APPLICATION = "application_context"
    }

    @Singleton
    @Provides
    fun provideBackgroundExecutor(): Executor = Executors.newFixedThreadPool(1)

    @Singleton
    @Provides
    fun provideHandlerExecutor(): MainThreadExecutor = MainThreadExecutor()

    @Provides
    fun provideTimber(): Timber.Tree = Timber.asTree()

    @Named(APPLICATION)
    @Provides
    fun providesContext(): Context = context

    @Provides
    fun providesResources(): Resources = context.resources

    @Singleton
    @Provides
    fun provideObjectMapper(): ObjectMapper = ObjectMapper()
        .registerModule(KotlinModule())
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    @Provides
    fun provideMainCategoryRepositoryImpl(retrofit: Retrofit): MainCategoryRepository =
        MainCategoryRepositoryImpl(retrofit.create(ChallengeServices::class.java), createCategoriesDataProvider())

    @Provides
    fun provideSubCategoryRepositoryImpl(): SubCategoryRepository =
        SubCategoryRepositoryImpl(createCategoriesDataProvider())
}