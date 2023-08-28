package co.aladinjunior.joker.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import co.aladinjunior.joker.R
import co.aladinjunior.joker.presentation.JokePresenter

class JokeFragment : Fragment() {



    private lateinit var jokeText: TextView
    private val presenter =  JokePresenter(this)

    companion object{
        const val CATEGORY_KEY = "category"

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         jokeText = view.findViewById(R.id.joke_text)




        val categoryName = arguments?.getString(CATEGORY_KEY)!!


        presenter.getJoke(categoryName)

        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.title = categoryName

        jokeText.text = categoryName



    }

    fun showJoke(joke: String){

        jokeText.text = joke




    }
}