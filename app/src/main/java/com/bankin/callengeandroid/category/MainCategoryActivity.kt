package com.bankin.callengeandroid.category

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bankin.callengeandroid.R
import com.bankin.callengeandroid.app.ChallengeApplication
import com.bankin.callengeandroid.subcategory.SubCategoryActivity
import com.challenge.mob.core.model.CategoriesViewModel
import com.nicolasmouchel.executordecorator.MutableDecorator
import kotlinx.android.synthetic.main.activity_main_category.*
import javax.inject.Inject

class MainCategoryActivity : AppCompatActivity(), MainCategoryView {

    @Inject
    lateinit var viewDecorator: MutableDecorator<MainCategoryView>

    @Inject
    lateinit var controller: MainCategoryController

    companion object {
        private const val CONTENT_CHILD = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_category)

        ChallengeApplication.getComponent(this)
            .plus(MainCategoryModule())
            .inject(this)

        viewDecorator.mutate(this)

        categoriesRecyclerView.layoutManager = LinearLayoutManager(this)
        controller.loadCategory()
    }

    override fun onDestroy() {
        viewDecorator.mutate(null)
        super.onDestroy()
    }

    override fun displayCategory(categories: List<CategoriesViewModel>) {
        categoriesRecyclerView.adapter = MainCategoryAdapter(this, categories, ::onCategoryClickListener)
        categoriesViewFlipper.displayedChild = CONTENT_CHILD
    }

    override fun displayError(exception: Throwable) {
        AlertDialog.Builder(this)
            .setTitle(R.string.error_title)
            .setMessage(R.string.an_error_happened)
            .setPositiveButton(R.string.ok, null)
            .create()
            .show()
    }

    private fun onCategoryClickListener(categoryId: String, categoryName: String) {
        startActivity(SubCategoryActivity.newIntent(this, categoryId, categoryName))
    }
}