package com.challenge.mob.repository.maincategory

import com.challenge.mob.core.entity.MainCategory
import com.challenge.mob.core.repository.CategoryException
import com.challenge.mob.repository.ChallengeServices
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.Buffer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@RunWith(MockitoJUnitRunner::class)
class MainCategoryRepositoryImplTest {

    private val server = MockWebServer()
    private lateinit var service: ChallengeServices
    private lateinit var repository: MainCategoryRepositoryImpl

    @Before
    fun setUp() {
        val mapper = ObjectMapper()

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder().addInterceptor(logging).build()

        service = Retrofit.Builder()
            .baseUrl(server.url("").toString())
            .addConverterFactory(JacksonConverterFactory.create(mapper.registerModule(KotlinModule())))
            .client(client)
            .build()
            .create(ChallengeServices::class.java)

        repository = MainCategoryRepositoryImpl(service, createCategoriesDataProvider())
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `loadCategory should not return an empty response`() {
        // Given
        val inputStream = javaClass.classLoader?.getResourceAsStream("categories_test.json")
        inputStream?.let {
            server.enqueue(MockResponse().setBody(Buffer().readFrom(inputStream)))
        }
        // When
        val categories = repository.loadCategory()

        // Then
        Assert.assertTrue(categories.isNotEmpty())
    }

    @Test
    fun `loadCategory should return only main category`() {
        // Given
        val inputStream = javaClass.classLoader?.getResourceAsStream("categories_test.json")
        inputStream?.let {
            server.enqueue(MockResponse().setBody(Buffer().readFrom(inputStream)))
        }
        val expectedMainCategory = listOf(
            MainCategory("171", "Abonnements"),
            MainCategory("163", "Santé")
        )

        // When
        val categories = repository.loadCategory()

        // Then
        Assert.assertEquals(expectedMainCategory, categories)
    }

    @Test(expected = CategoryException::class)
    fun `loadCategory should throw an exception if failure`() {
        // Given
        val inputStream = javaClass.classLoader?.getResourceAsStream("")
        inputStream?.let {
            server.enqueue(MockResponse().setBody(Buffer().readFrom(inputStream)))
        }

        // When
        repository.loadCategory()
    }
}