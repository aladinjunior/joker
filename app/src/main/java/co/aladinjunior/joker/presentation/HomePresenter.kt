package co.aladinjunior.joker.presentation

import android.os.Handler
import android.os.Looper
import android.view.View
import co.aladinjunior.joker.model.Category
import co.aladinjunior.joker.view.CategoryItem

class HomePresenter(private val callback: Callback) {


    fun getCategories() {
        fakeRequest()
    }

    private fun onSuccess(serverResponse: List<String>) {

        val categoryList = mutableListOf<Category>()
        val viewHolder = mutableListOf<CategoryItem>()

        for (categoryTitle in serverResponse) {
            categoryList.add(Category(categoryTitle, 0xFFFF0000))

        }
        for (categories in categoryList) {
            viewHolder.add(CategoryItem(categories))
        }



        callback.showCategories(viewHolder)




    }

    private fun fakeRequest() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val serverResponse = listOf(
                "Category 1",
                "Category 2",
                "Category 3",
                "Category 4"
            )

            onSuccess(serverResponse)
            callback.onComplete()


        }, 2000)
    }
}