package com.challenge.mob.core.interactor

import com.challenge.mob.core.entity.SubCategory
import com.challenge.mob.core.presenter.SubCategoryPresenter
import com.challenge.mob.core.repository.RepositoryException
import com.challenge.mob.core.repository.SubCategoryRepository
import javax.inject.Inject

open class SubCategoryInteractor @Inject constructor(
    private val subCategoryRepository: SubCategoryRepository,
    private val subCategoryPresenter: SubCategoryPresenter
) {

    open fun loadSubCategories(mainCategoryId: String) {
        val subCategoryResponse = try {
            val response = subCategoryRepository.loadSubCategory(mainCategoryId)
            SubCategoryResponse.Success(response)
        } catch (e: RepositoryException) {
            SubCategoryResponse.Failure(e)
        }
        subCategoryPresenter.present(subCategoryResponse)
    }

    sealed class SubCategoryResponse {
        data class Success(val subCategories: List<SubCategory>) : SubCategoryResponse()
        data class Failure(val exception: Throwable) : SubCategoryResponse()
    }
}