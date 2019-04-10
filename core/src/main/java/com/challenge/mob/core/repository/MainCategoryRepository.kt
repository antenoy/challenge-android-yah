package com.challenge.mob.core.repository

import com.challenge.mob.core.entity.MainCategory

interface MainCategoryRepository {
    @Throws(RepositoryException::class)
    fun loadCategory(): List<MainCategory>
}

class CategoryException : RepositoryException()