package com.bankin.callengeandroid.subcategory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bankin.callengeandroid.R
import com.bankin.callengeandroid.app.ChallengeApplication
import com.challenge.mob.core.model.SubCategoriesViewModel
import com.nicolasmouchel.executordecorator.MutableDecorator
import timber.log.Timber
import javax.inject.Inject

class SubCategoryActivity : AppCompatActivity(), SubCategoryView {

    @Inject
    lateinit var viewDecorator: MutableDecorator<SubCategoryView>

    @Inject
    lateinit var controller: SubCategoryController

    companion object {

        private const val CATEGORY_ID = "CATEGORY_ID"
        private const val CATEGORY_NAME = "CATEGORY_NAME"

        @JvmStatic
        fun newIntent(
            context: Context,
            categoryId: String,
            categoryName: String
        ): Intent {
            val intent = Intent(context, SubCategoryActivity::class.java)
            intent.putExtra(CATEGORY_ID, categoryId)
            intent.putExtra(CATEGORY_NAME, categoryName)
            return intent
        }
    }

    private val mainCategoryId: String by lazy {
        intent.getStringExtra(CATEGORY_ID)
    }

    private val mainCategoryName: String by lazy {
        intent.getStringExtra(CATEGORY_NAME)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        ChallengeApplication.getComponent(this)
            .plus(SubCategoryModule())
            .inject(this)

        viewDecorator.mutate(this)

        title = mainCategoryName

        controller.loadSubCategories(mainCategoryId)
    }

    override fun onDestroy() {
        viewDecorator.mutate(null)
        super.onDestroy()
    }

    override fun displaySubCategories(subCategoriesViewModel: List<SubCategoriesViewModel>) {
        Timber.d("SUB CATEGORIES -------------------> $subCategoriesViewModel")
    }

    override fun displayError(exception: Throwable) {

    }
}
