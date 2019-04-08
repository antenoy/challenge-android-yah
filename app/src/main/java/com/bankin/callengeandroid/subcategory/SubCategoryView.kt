package com.bankin.callengeandroid.subcategory

import com.challenge.mob.core.model.SubCategoriesViewModel

interface SubCategoryView {
    fun displaySubCategories(subCategoriesViewModel: List<SubCategoriesViewModel>)
    fun displayError(exception: Throwable)
}