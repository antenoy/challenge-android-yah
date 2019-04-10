package com.challenge.mob.core.entity

data class SubCategoriesItems(
    val id: String,
    val name: String,
    val parent: ParentCategory
)

data class ParentCategory(
    val id: String?
)