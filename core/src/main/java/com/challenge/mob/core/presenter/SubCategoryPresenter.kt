package com.challenge.mob.core.presenter

import com.challenge.mob.core.interactor.SubCategoryInteractor

interface SubCategoryPresenter {
    fun present(response: SubCategoryInteractor.SubCategoryResponse)
}