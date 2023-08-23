package co.aladinjunior.joker.presentation

import android.os.Handler
import android.os.Looper
import co.aladinjunior.joker.model.Category
import co.aladinjunior.joker.view.CategoryItem

class HomePresenter(private val callback: Callback) {




    fun getCategories(){
        fakeRequest()
    }

    private fun onSuccess(categories: List<Category>){

        val viewHolder = mutableListOf<CategoryItem>()
        for (category in categories){
             viewHolder.add(CategoryItem(category))
        }

        callback.showCategories(viewHolder)


    }

    private fun fakeRequest(){
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val categories = listOf(
                Category("Category 1", 0xFFFF0000),
                Category("Category 2", 0xFF00FF00),
                Category("Category 3", 0xFF0000FF),
                Category("Category 4", 0xFFFFFF00))

            onSuccess(categories)

        }, 2000)
    }
}