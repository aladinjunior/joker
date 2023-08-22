package co.aladinjunior.joker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.aladinjunior.joker.R
import co.aladinjunior.joker.model.Category
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val rv = view.findViewById<RecyclerView>(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(activity)
        val adapter = GroupieAdapter()
        rv.adapter = adapter
        

        adapter.add(CategoryItem(Category("Category 1", 0xFFFF0000)))
        adapter.add(CategoryItem(Category("Category 2", 0xFF00FF00)))
        adapter.add(CategoryItem(Category("Category 3", 0xFF0000FF)))
        adapter.add(CategoryItem(Category("Category 4", 0xFFFFFF00)))
        adapter.notifyDataSetChanged()


    }
}