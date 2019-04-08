package com.challenge.mob.repository.subcategory

import com.challenge.mob.core.dataprovider.CategoriesDataProvider
import com.challenge.mob.core.entity.AllCategoriesItems
import com.challenge.mob.core.entity.SubCategory
import com.challenge.mob.core.repository.SubCategoryRepository
import javax.inject.Inject

class SubCategoryRepositoryImpl @Inject constructor(
    private val categoriesDataProvider: CategoriesDataProvider
) : SubCategoryRepository {

    override fun loadSubCategory(mainCategoryId: String): List<SubCategory> {
        val categories = categoriesDataProvider.getCategories()
        return transformToEntity(categories, mainCategoryId)
    }

    private fun transformToEntity(
        categories: List<AllCategoriesItems>,
        mainCategoryId: String
    ): List<SubCategory> =
        categories
            .filter { it.parent.id == mainCategoryId }
            .map {
                SubCategory(
                    it.name
                )
            }
}