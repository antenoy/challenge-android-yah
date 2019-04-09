package com.bankin.callengeandroid.subcategory

import com.challenge.mob.core.entity.SubCategory
import com.challenge.mob.core.interactor.SubCategoryInteractor
import com.challenge.mob.core.interactor.SubCategoryInteractor.SubCategoryResponse.Failure
import com.challenge.mob.core.interactor.SubCategoryInteractor.SubCategoryResponse.Success
import com.challenge.mob.core.model.SubCategoriesViewModel
import com.challenge.mob.core.presenter.SubCategoryPresenter
import javax.inject.Inject

class SubCategoryPresenterImpl @Inject constructor(
    private val view: SubCategoryView
) : SubCategoryPresenter {
    override fun present(response: SubCategoryInteractor.SubCategoryResponse) {
        when (response) {
            is Success -> view.displaySubCategories(response.subCategories.toSubCategoriesViewModel())
            is Failure -> view.displayError(response.exception)
        }
    }

    private fun List<SubCategory>.toSubCategoriesViewModel(): List<SubCategoriesViewModel> =
        map { subCategory ->
            SubCategoriesViewModel(subCategory.name)
        }
}