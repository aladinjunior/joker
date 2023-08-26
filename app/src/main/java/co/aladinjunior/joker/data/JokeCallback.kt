package co.aladinjunior.joker.data

import co.aladinjunior.joker.model.Joke

interface JokeCallback {

    fun onSuccess(response: Joke)
    fun onComplete()
    fun onError(message: String)

}