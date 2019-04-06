package com.bankin.callengeandroid.category

import com.challenge.mob.core.model.CategoriesViewModel

interface MainCategoryView {
    fun displayCategory(categories: List<CategoriesViewModel>)
    fun displayError(exception: Throwable)
}
