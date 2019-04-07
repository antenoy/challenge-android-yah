package com.bankin.callengeandroid.subcategory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bankin.callengeandroid.R
import timber.log.Timber

class SubCategoryActivity : AppCompatActivity() {

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

    private val categoryId: String by lazy {
        intent.getStringExtra(CATEGORY_ID)
    }

    private val categoryName: String by lazy {
        intent.getStringExtra(CATEGORY_NAME)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        title = categoryName

        Timber.d("CATEGORY ID -----------------------> $categoryId")
        Timber.d("CATEGORY NAME----------------------> $categoryName")
    }
}
