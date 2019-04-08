package com.challenge.mob.core.interactor

import com.challenge.mob.core.entity.MainCategory
import com.challenge.mob.core.presenter.MainCategoryPresenter
import com.challenge.mob.core.repository.MainCategoryRepository
import com.challenge.mob.core.repository.RepositoryException
import javax.inject.Inject

open class MainCategoryInteractor @Inject constructor(
    private val mainCategoryRepository: MainCategoryRepository,
    private val mainCategoryPresenter: MainCategoryPresenter
) {
    open fun loadCategory() {
        val categoryResponse = try {
            val response = mainCategoryRepository.loadCategory()
            MainCategoryResponse.Success(response)
        } catch (e: RepositoryException) {
            MainCategoryResponse.Failure(e)
        }
        mainCategoryPresenter.present(categoryResponse)
    }

    sealed class MainCategoryResponse {
        data class Success(val categories: List<MainCategory>) : MainCategoryResponse()
        data class Failure(val exception: Throwable) : MainCategoryResponse()
    }
}