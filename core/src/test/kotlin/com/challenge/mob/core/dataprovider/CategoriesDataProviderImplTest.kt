package com.challenge.mob.core.dataprovider

import com.challenge.mob.core.entity.ParentCategory
import com.challenge.mob.core.entity.SubCategoriesItems
import com.challenge.mob.core.repository.local.CategoriesLocalRepository
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito.mock
import org.mockito.Mockito.only

class CategoriesDataProviderImplTest {

    private lateinit var dataProvider: CategoriesDataProviderImpl
    private lateinit var categoriesLocalRepository: CategoriesLocalRepository

    @Before
    fun setUp() {
        categoriesLocalRepository = mock(CategoriesLocalRepository::class.java)
        dataProvider = CategoriesDataProviderImpl(categoriesLocalRepository)
    }

    @Test
    fun `setCategories should set AllCategoriesItems`() {
        // Given
        val allCategoriesItems = listOf(
            SubCategoriesItems(
                id = "id1",
                name = "name1",
                parent = ParentCategory("idParent1")
            ),
            SubCategoriesItems(
                id = "id2",
                name = "name2",
                parent = ParentCategory("idParent2")
            )
        )

        // When
        dataProvider.setCategories(allCategoriesItems)

        // Then
        then(categoriesLocalRepository).should(only()).setCategories(allCategoriesItems)
    }

    @Test
    fun `getCategories should get AllCategoriesItems`() {
        // Given
        // When
        dataProvider.getCategories()

        // Then
        then(categoriesLocalRepository).should(only()).getCategories()
    }
}