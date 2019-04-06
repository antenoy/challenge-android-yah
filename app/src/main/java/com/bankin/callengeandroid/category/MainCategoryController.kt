package com.bankin.callengeandroid.category

import com.challenge.mob.core.interactor.MainCategoryInteractor
import javax.inject.Inject

interface MainCategoryController {
    fun loadCategory()
}

class MainCategoryControllerImpl @Inject constructor(val interactor: MainCategoryInteractor) : MainCategoryController {
    override fun loadCategory() {
        interactor.loadCategory()
    }
}