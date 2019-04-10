package com.challenge.mob.core.dataprovider

import com.challenge.mob.core.entity.SubCategoriesItems
import com.challenge.mob.core.repository.local.CategoriesLocalRepository

interface CategoriesDataProvider {
    fun setCategories(subCategoriesItems: List<SubCategoriesItems>)
    fun getCategories(): List<SubCategoriesItems>
}

class CategoriesDataProviderImpl(
    private val categoriesLocalRepository: CategoriesLocalRepository
) : CategoriesDataProvider {
    override fun setCategories(subCategoriesItems: List<SubCategoriesItems>) {
        categoriesLocalRepository.setCategories(subCategoriesItems)
    }

    override fun getCategories(): List<SubCategoriesItems> = categoriesLocalRepository.getCategories()

}