package com.challenge.mob.repository.subcategory

import com.challenge.mob.core.dataprovider.CategoriesDataProvider
import com.challenge.mob.core.entity.SubCategoriesItems
import com.challenge.mob.core.entity.SubCategory
import com.challenge.mob.core.repository.SubCategoryException
import com.challenge.mob.core.repository.SubCategoryRepository
import javax.inject.Inject

class SubCategoryRepositoryImpl @Inject constructor(
    private val categoriesDataProvider: CategoriesDataProvider
) : SubCategoryRepository {

    override fun loadSubCategory(mainCategoryId: String): List<SubCategory> {
        val categories = categoriesDataProvider.getCategories()
        if (categories.isNotEmpty()) {
            return transformToEntity(categories, mainCategoryId)
        } else {
            throw SubCategoryException()
        }
    }

    private fun transformToEntity(
        categories: List<SubCategoriesItems>,
        mainCategoryId: String
    ): List<SubCategory> =
        categories
            .filter { it.parent.id == mainCategoryId }
            .map {
                SubCategory(
                    it.name
                )
            }.sortedBy { it.name }
}