package com.challenge.mob.repository.maincategory

import com.challenge.mob.core.dataprovider.CategoriesDataProvider
import com.challenge.mob.core.entity.MainCategory
import com.challenge.mob.core.entity.ParentCategory
import com.challenge.mob.core.entity.SubCategoriesItems
import com.challenge.mob.core.repository.CategoryException
import com.challenge.mob.core.repository.MainCategoryRepository
import com.challenge.mob.repository.ChallengeServices
import java.io.IOException

class MainCategoryRepositoryImpl(
    private val challengeServices: ChallengeServices,
    private val categoriesDataProvider: CategoriesDataProvider
) : MainCategoryRepository {

    override fun loadCategory(): List<MainCategory> {
        try {
            val response = challengeServices.getCategory().execute()
            val jsonResources = response.body() ?: throw CategoryException()
            categoriesDataProvider.setCategories(jsonResources.toAllCategories())
            return transformToEntity(jsonResources)
        } catch (e: IOException) {
            throw CategoryException()
        }
    }

    private fun transformToEntity(jsonResources: JsonRessources): List<MainCategory> =
        jsonResources.resources
            .filter { it.parent == null }
            .map { jsonMainCategory ->
                MainCategory(
                    jsonMainCategory.id,
                    jsonMainCategory.name
                )
            }.sortedBy { mainCategory -> mainCategory.name }

    private fun JsonRessources.toAllCategories(): List<SubCategoriesItems> =
        resources.filter { it.parent != null }
            .map { jsonMainCategory ->
                SubCategoriesItems(
                    jsonMainCategory.id,
                    jsonMainCategory.name,
                    ParentCategory(jsonMainCategory.parent?.id)
                )
            }
}