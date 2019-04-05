package com.bankin.callengeandroid.category

import javax.inject.Inject

interface MainCategoryController {
    fun loadCategory()
}

class MainCategoryControllerImpl @Inject constructor(/*val interactor: MainCategoryInteractor*/) : MainCategoryController {
    override fun loadCategory() {

    }
}