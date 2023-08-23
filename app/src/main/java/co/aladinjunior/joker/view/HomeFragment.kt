package co.aladinjunior.joker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.aladinjunior.joker.R
import co.aladinjunior.joker.model.Category
import co.aladinjunior.joker.presentation.Callback
import co.aladinjunior.joker.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment(), Callback {

    private val presenter = HomePresenter(this)
    private val adapter = GroupieAdapter()
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getCategories()


        progressBar = view.findViewById(R.id.main_progress)

        val rv = view.findViewById<RecyclerView>(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = adapter





    }

    override fun showCategories(viewHolder: List<CategoryItem>) {

        adapter.addAll(viewHolder)
        adapter.notifyDataSetChanged()


    }

    

    override fun onComplete() {
        progressBar.visibility = View.GONE

    }


}