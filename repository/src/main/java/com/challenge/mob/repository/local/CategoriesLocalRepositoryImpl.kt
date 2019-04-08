package com.challenge.mob.repository.local

import com.challenge.mob.core.dataprovider.CategoriesDataProvider
import com.challenge.mob.core.dataprovider.CategoriesDataProviderImpl
import com.challenge.mob.core.entity.AllCategoriesItems
import com.challenge.mob.core.repository.local.CategoriesLocalRepository
import com.orhanobut.hawk.Hawk

fun createCategoriesDataProvider(): CategoriesDataProvider = CategoriesDataProviderImpl(CategoriesLocalRepositoryImpl())

internal class CategoriesLocalRepositoryImpl : CategoriesLocalRepository {

    companion object {
        private const val CATEGORIES = "CATEGORIES"
    }

    override fun setCategories(allCategoriesItems: List<AllCategoriesItems>) {
        Hawk.put(CATEGORIES, allCategoriesItems)
    }

    override fun getCategories(): List<AllCategoriesItems> = Hawk.get(CATEGORIES)
}