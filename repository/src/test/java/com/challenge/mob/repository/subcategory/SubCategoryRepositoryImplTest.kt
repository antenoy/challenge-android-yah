package com.challenge.mob.repository.subcategory

import com.challenge.mob.core.dataprovider.CategoriesDataProvider
import com.challenge.mob.core.entity.SubCategoriesItems
import com.challenge.mob.core.entity.ParentCategory
import com.challenge.mob.core.entity.SubCategory
import com.challenge.mob.core.repository.SubCategoryException
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
    fun `loadSubCategory should return all Sub Categories`() {
        // Given
        val mainCategoryId = "mainCategoryId"
        val allCategoriesItems = listOf(
            SubCategoriesItems(
                "id2",
                "name2",
                ParentCategory("mainCategoryId")
            ),
            SubCategoriesItems(
                "id1",
                "name1",
                ParentCategory("mainCategoryId")
            ),
            SubCategoriesItems(
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

    @Test(expected = SubCategoryException::class)
    fun `loadSubCategory should throw exception if sub categories is empty`() {
        // Given
        val mainCategoryId = "mainCategoryId"
        val allCategoriesItems = emptyList<SubCategoriesItems>()

        given(categoriesDataProvider.getCategories()).willReturn(allCategoriesItems)

        // When
        repository.loadSubCategory(mainCategoryId)
    }
}