package co.aladinjunior.joker.presentation

import androidx.fragment.app.Fragment
import co.aladinjunior.joker.data.JokeCallback
import co.aladinjunior.joker.data.RemoteDataSource
import co.aladinjunior.joker.model.Category
import co.aladinjunior.joker.model.Joke
import co.aladinjunior.joker.view.JokeFragment
import co.aladinjunior.joker.view.SetDataOnView

class JokePresenter(
    private val view: SetDataOnView,
    private val dataSource: RemoteDataSource = RemoteDataSource()
) : JokeCallback {

    fun getJoke(categoryName: String){
        dataSource.getJokes(this, categoryName)
    }




    override fun onSuccess(response: Joke) {
        view.showJoke(response)

    }

    override fun onComplete() {
    }

    override fun onError(message: String) {
    }


}