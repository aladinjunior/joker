package co.aladinjunior.joker.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import co.aladinjunior.joker.R
import co.aladinjunior.joker.model.Joke
import co.aladinjunior.joker.presentation.JokePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class JokeFragment : Fragment(), SetDataOnView{


    private lateinit var jokeText: TextView
    private lateinit var jokeIcon: ImageView
    private val presenter = JokePresenter(this)

    companion object {
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
        jokeIcon = view.findViewById(R.id.joke_icon)

        val categoryName = arguments?.getString(CATEGORY_KEY)!!


        presenter.getJoke(categoryName)

        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.title = categoryName

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            presenter.getJoke(categoryName)
        }


    }

    override fun showJoke(joke: Joke) {
        jokeText.text = joke.joke
        Picasso.get().load(joke.iconUrl).into(jokeIcon)
    }


}