package com.challenge.mob.repository.subcategory

import com.challenge.mob.core.dataprovider.CategoriesDataProvider
import com.challenge.mob.core.entity.AllCategoriesItems
import com.challenge.mob.core.entity.ParentCategory
import com.challenge.mob.core.entity.SubCategory
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SubCategoryRepositoryImplTest {

    @Mock
    private lateinit var categoriesDataProvider: CategoriesDataProvider

    @InjectMocks
    private lateinit var repository: SubCategoryRepositoryImpl

    @Test
    fun loadSubCategory() {
        // Given
        val mainCategoryId = "mainCategoryId"
        val allCategoriesItems = listOf(
            AllCategoriesItems(
                "id2",
                "name2",
                ParentCategory("mainCategoryId")
            ),
            AllCategoriesItems(
                "id1",
                "name1",
                ParentCategory("mainCategoryId")
            ),
            AllCategoriesItems(
                "id3",
                "name3",
                ParentCategory("parentId")
            )
        )

        val expectedSubCategories = listOf(
            SubCategory(
                "name1"
            ),
            SubCategory(
                "name2"
            )
        )

        given(categoriesDataProvider.getCategories()).willReturn(allCategoriesItems)

        // When
        val subcategories = repository.loadSubCategory(mainCategoryId)

        // Then
        Assert.assertEquals(subcategories, expectedSubCategories)
    }
}