package com.bankin.callengeandroid.app

import com.bankin.callengeandroid.category.MainCategoryComponent
import com.bankin.callengeandroid.category.MainCategoryModule
import com.bankin.callengeandroid.subcategory.SubCategoryComponent
import com.bankin.callengeandroid.subcategory.SubCategoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, NetworkModule::class])
interface MainComponent {
    fun plus(module: MainCategoryModule): MainCategoryComponent
    fun plus(module: SubCategoryModule): SubCategoryComponent
}