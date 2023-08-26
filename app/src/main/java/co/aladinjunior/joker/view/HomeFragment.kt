package co.aladinjunior.joker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.aladinjunior.joker.R
import co.aladinjunior.joker.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

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


        progressBar = view.findViewById(R.id.main_progress)

        if (adapter.itemCount == 0) presenter.getCategories()




        val rv = view.findViewById<RecyclerView>(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = adapter



        adapter.setOnItemClickListener { item, view ->
            val bundle = Bundle()
            val categoryName = (item as CategoryItem).category.name
            bundle.putString(JokeFragment.CATEGORY_KEY, categoryName)
            findNavController().navigate(R.id.nav_home_to_nav_joke, bundle)
        }

    }

     fun showCategories(viewHolder: List<CategoryItem>) {
        adapter.addAll(viewHolder)
        adapter.notifyDataSetChanged()

    }

    fun showProgress(){
        progressBar.visibility = View.VISIBLE
    }

    fun showFailure(message: String){
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }



    fun hideProgress(){
        progressBar.visibility = View.GONE
    }








}