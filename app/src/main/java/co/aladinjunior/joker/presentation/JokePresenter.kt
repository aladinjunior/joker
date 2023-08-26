package co.aladinjunior.joker.presentation

import co.aladinjunior.joker.data.JokeCallback
import co.aladinjunior.joker.data.RemoteDataSource
import co.aladinjunior.joker.model.Category
import co.aladinjunior.joker.model.Joke
import co.aladinjunior.joker.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: RemoteDataSource = RemoteDataSource(),
) : JokeCallback {

    fun getJoke(){
        dataSource.getJokes(this)
    }




    override fun onSuccess(response: Joke) {
        view.showJoke("x", response.joke)

    }

    override fun onComplete() {
    }

    override fun onError(message: String) {
    }


}