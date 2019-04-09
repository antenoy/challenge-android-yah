package com.challenge.mob.core.dataprovider

import com.challenge.mob.core.entity.AllCategoriesItems
import com.challenge.mob.core.repository.local.CategoriesLocalRepository

interface CategoriesDataProvider {
    fun setCategories(allCategoriesItems: List<AllCategoriesItems>)
    fun getCategories(): List<AllCategoriesItems>
}

class CategoriesDataProviderImpl(
    private val categoriesLocalRepository: CategoriesLocalRepository
) : CategoriesDataProvider {
    override fun setCategories(allCategoriesItems: List<AllCategoriesItems>) {
        categoriesLocalRepository.setCategories(allCategoriesItems)
    }

    override fun getCategories(): List<AllCategoriesItems> = categoriesLocalRepository.getCategories()

}