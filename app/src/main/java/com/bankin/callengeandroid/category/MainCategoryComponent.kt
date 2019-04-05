package com.bankin.callengeandroid.category

import com.bankin.callengeandroid.app.FeatureScope
import dagger.Subcomponent

@FeatureScope
@Subcomponent(modules = [MainCategoryModule::class])
interface MainCategoryComponent {
    fun inject(activity: MainCategoryActivity)
}