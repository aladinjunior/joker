package co.aladinjunior.joker.presentation

import android.os.Handler
import android.os.Looper
import co.aladinjunior.joker.data.Callback
import co.aladinjunior.joker.data.RemoteDataSource
import co.aladinjunior.joker.model.Category
import co.aladinjunior.joker.view.CategoryItem
import co.aladinjunior.joker.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: RemoteDataSource = RemoteDataSource()) : Callback{



    fun getCategories() {
        dataSource.fakeRequest(this)
    }




    override fun onSuccess(response: List<String>) {
        val categoryList = mutableListOf<Category>()
        val viewHolder = mutableListOf<CategoryItem>()
        for (categoryTitle in response) {
            categoryList.add(Category(categoryTitle, 0xFFFF0000))
        }
        for (categories in categoryList) {
            viewHolder.add(CategoryItem(categories))
        }
        view.showCategories(viewHolder)



    }


    override fun onComplete() {
       view.hideProgress()
    }


}