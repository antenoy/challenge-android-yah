package com.bankin.callengeandroid.app

import com.bankin.callengeandroid.category.MainCategoryComponent
import com.bankin.callengeandroid.category.MainCategoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, NetworkModule::class])
interface MainComponent {
    fun plus(module: MainCategoryModule): MainCategoryComponent
}