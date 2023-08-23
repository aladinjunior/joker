package co.aladinjunior.joker.presentation

import co.aladinjunior.joker.view.CategoryItem

interface Callback {

    fun showCategories(viewHolder: List<CategoryItem>)

    fun onComplete()
}