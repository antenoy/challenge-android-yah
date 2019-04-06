package com.bankin.callengeandroid.category

import com.challenge.mob.core.entity.MainCategory
import com.challenge.mob.core.interactor.MainCategoryInteractor.MainCategoryResponse
import com.challenge.mob.core.interactor.MainCategoryInteractor.MainCategoryResponse.Failure
import com.challenge.mob.core.interactor.MainCategoryInteractor.MainCategoryResponse.Success
import com.challenge.mob.core.model.CategoriesViewModel
import com.challenge.mob.core.presenter.MainCategoryPresenter
import javax.inject.Inject

class MainCategoryPresenterImpl @Inject constructor(
    private val view: MainCategoryView
) : MainCategoryPresenter {
    override fun present(response: MainCategoryResponse) {
        when (response) {
            is Success -> view.displayCategory(response.categories.toCategoriesViewModel())
            is Failure -> view.displayError(response.exception)
        }
    }

    private fun List<MainCategory>.toCategoriesViewModel(): List<CategoriesViewModel> =
        map { mainCategory ->
            CategoriesViewModel(mainCategory.id, mainCategory.name)
        }
}


