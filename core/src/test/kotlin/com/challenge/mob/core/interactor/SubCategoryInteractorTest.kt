package com.challenge.mob.core.interactor

import com.challenge.mob.core.entity.SubCategory
import com.challenge.mob.core.presenter.SubCategoryPresenter
import com.challenge.mob.core.repository.RepositoryException
import com.challenge.mob.core.repository.SubCategoryRepository
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.only
import com.nhaarman.mockito_kotlin.then
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SubCategoryInteractorTest {

    @Mock
    private lateinit var repository: SubCategoryRepository

    @Mock
    private lateinit var presenter: SubCategoryPresenter

    @InjectMocks
    private lateinit var interactor: SubCategoryInteractor

    @Test
    fun `loadSubCategories should call present with success result`() {
        // Given
        val mainCategoryId = "mainCategoryId"
        val subCategories = listOf(
            SubCategory("name1"),
            SubCategory("name2")
        )

        given(repository.loadSubCategory(mainCategoryId)).willReturn(subCategories)

        // When
        interactor.loadSubCategories(mainCategoryId)

        // Then
        then(presenter).should(only()).present(
            SubCategoryInteractor.SubCategoryResponse.Success(
                subCategories
            )
        )
    }

    @Test
    fun `loadSubCategories should catch RepositoryException and present with failure result`() {
        // Given
        val mainCategoryId = "mainCategoryId"
        val exception = mock(RepositoryException::class.java)

        given(repository.loadSubCategory(mainCategoryId)).willThrow(exception)

        // When
        interactor.loadSubCategories(mainCategoryId)

        // Then
        then(presenter).should(only()).present(
            SubCategoryInteractor.SubCategoryResponse.Failure(
                exception
            )
        )
    }
}