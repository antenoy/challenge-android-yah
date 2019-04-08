package com.bankin.callengeandroid.subcategory

import com.challenge.mob.core.interactor.SubCategoryInteractor
import javax.inject.Inject

interface SubCategoryController {
    fun loadSubCategories(mainCategoryId: String)
}

class SubCategoryControllerImpl @Inject constructor(
    private val interactor: SubCategoryInteractor
) : SubCategoryController {
    override fun loadSubCategories(mainCategoryId: String) {
        interactor.loadSubCategories(mainCategoryId)
    }
}