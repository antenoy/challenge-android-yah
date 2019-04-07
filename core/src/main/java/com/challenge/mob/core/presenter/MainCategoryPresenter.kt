package com.challenge.mob.core.presenter

import com.challenge.mob.core.interactor.MainCategoryInteractor

interface MainCategoryPresenter {
    fun present(response: MainCategoryInteractor.MainCategoryResponse)
}