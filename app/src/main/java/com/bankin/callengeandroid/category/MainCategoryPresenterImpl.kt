package com.bankin.callengeandroid.category

import com.challenge.mob.core.interactor.MainCategoryInteractor.MainCategoryResponse
import com.challenge.mob.core.interactor.MainCategoryInteractor.MainCategoryResponse.Failure
import com.challenge.mob.core.interactor.MainCategoryInteractor.MainCategoryResponse.Success
import com.challenge.mob.core.presenter.MainCategoryPresenter
import javax.inject.Inject

class MainCategoryPresenterImpl @Inject constructor(
    private val view: MainCategoryView
) : MainCategoryPresenter {
    override fun present(response: MainCategoryResponse) {
        when (response) {
            is Success -> view.displayCategory(response.categories)
            is Failure -> view.displayError()
        }
    }
}