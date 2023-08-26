package co.aladinjunior.joker.data

import co.aladinjunior.joker.view.CategoryItem

interface CategoryListCallback {

    fun onSuccess(response: List<String>)
    fun onComplete()
    fun onError(message: String)
}