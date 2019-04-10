package com.challenge.mob.core.repository

import com.challenge.mob.core.entity.SubCategory

interface SubCategoryRepository {
    @Throws(RepositoryException::class)
    fun loadSubCategory(mainCategoryId: String): List<SubCategory>
}

class SubCategoryException : RepositoryException()