package com.challenge.mob.core.repository.local

import com.challenge.mob.core.entity.AllCategoriesItems

interface CategoriesLocalRepository {
    fun setCategories(allCategoriesItems: List<AllCategoriesItems>)
    fun getCategories(): List<AllCategoriesItems>
}