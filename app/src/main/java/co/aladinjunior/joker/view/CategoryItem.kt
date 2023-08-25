package co.aladinjunior.joker.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import co.aladinjunior.joker.R
import co.aladinjunior.joker.model.Category
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem(val category: Category) : Item<CategoryItem.ViewHolder>() {

    override fun createViewHolder(itemView: View): ViewHolder {
        return ViewHolder(itemView)
    }


    override fun bind(viewHolder: ViewHolder, position: Int) {
        val name = viewHolder.itemView.findViewById<TextView>(R.id.category_name)
        name.text = category.name
        val bgColor = viewHolder.itemView.findViewById<LinearLayout>(R.id.category_container)
        bgColor.setBackgroundColor(category.bgColor.toInt())

    }

    override fun getLayout(): Int {
        return R.layout.category_item
    }

    class ViewHolder(view: View) : GroupieViewHolder(view)

}