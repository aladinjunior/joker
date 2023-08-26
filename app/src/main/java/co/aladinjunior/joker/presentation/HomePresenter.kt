package co.aladinjunior.joker.presentation

import android.graphics.Color
import co.aladinjunior.joker.data.CategoryListCallback
import co.aladinjunior.joker.data.RemoteDataSource
import co.aladinjunior.joker.model.Category
import co.aladinjunior.joker.view.CategoryItem
import co.aladinjunior.joker.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: RemoteDataSource = RemoteDataSource()) : CategoryListCallback{



    fun getCategories() {
        view.showProgress()
        dataSource.getCategoryList(this)
    }




    override fun onSuccess(response: List<String>) {
        val categoryList = mutableListOf<Category>()
        val viewHolder = mutableListOf<CategoryItem>()
        val start = 40
        val end = 190
        val diff = (end - start) / response.size
        for (categoryTitle in response) {
            val hsv = floatArrayOf(
                start + (diff * response.indexOf(categoryTitle)).toFloat(),
                100.0f,
                100.0f
            )
            categoryList.add(Category(categoryTitle, Color.HSVToColor(hsv).toLong()))
        }
        for (categories in categoryList) {
            viewHolder.add(CategoryItem(categories))
        }
        view.showCategories(viewHolder)



    }


    override fun onComplete() {
       view.hideProgress()
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }


}