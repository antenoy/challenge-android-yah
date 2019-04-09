package com.bankin.callengeandroid.subcategory

import com.bankin.callengeandroid.app.FeatureScope
import dagger.Subcomponent

@FeatureScope
@Subcomponent(modules = [SubCategoryModule::class])
interface SubCategoryComponent {
    fun inject(activity: SubCategoryActivity)
}