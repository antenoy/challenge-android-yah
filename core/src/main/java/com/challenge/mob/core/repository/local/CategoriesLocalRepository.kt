package com.challenge.mob.core.repository.local

import com.challenge.mob.core.entity.SubCategoriesItems

interface CategoriesLocalRepository {
    fun setCategories(subCategoriesItems: List<SubCategoriesItems>)
    fun getCategories(): List<SubCategoriesItems>
}