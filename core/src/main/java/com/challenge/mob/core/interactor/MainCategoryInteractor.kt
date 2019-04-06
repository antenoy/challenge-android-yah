package com.challenge.mob.core.interactor

import com.challenge.mob.core.entity.MainCategory
import com.challenge.mob.core.presenter.MainCategoryPresenter
import com.challenge.mob.core.repository.MainCategoryRepository
import javax.inject.Inject

class MainCategoryInteractor @Inject constructor(
    private val mainCategoryRepository: MainCategoryRepository,
    private val maincategoryPresenter: MainCategoryPresenter
) {
    fun loadCategory() {
        val response = try {
            val response = mainCategoryRepository.loadCategory()
            MainCategoryResponse.Success(response)
        } catch (failure: MainCategoryRepository.Failure) {
            MainCategoryResponse.Failure(failure)
        }
        maincategoryPresenter.present(response)
    }

    sealed class MainCategoryResponse {
        data class Success(val categories: List<MainCategory>) : MainCategoryResponse()
        data class Failure(val exception: Exception) : MainCategoryResponse()
    }
}