package co.aladinjunior.joker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import co.aladinjunior.joker.R
import co.aladinjunior.joker.model.Joke
import co.aladinjunior.joker.presentation.JokePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class JokeDayFragment : Fragment(), SetDataOnView {


    private lateinit var jokeText: TextView
    private lateinit var jokeIcon: ImageView

    private val presenter = JokePresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        jokeText = view.findViewById(R.id.joke_text)
        jokeIcon = view.findViewById(R.id.joke_icon)

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {

        }
    }

    override fun showJoke(joke: Joke) {
        jokeText.text = joke.joke
        Picasso.get().load(joke.iconUrl).into(jokeIcon)
    }
}