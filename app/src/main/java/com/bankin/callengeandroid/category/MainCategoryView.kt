package com.bankin.callengeandroid.category

import com.challenge.mob.core.entity.MainCategory

interface MainCategoryView {
    fun displayCategory(categories: List<MainCategory>)
    fun displayError()
}
