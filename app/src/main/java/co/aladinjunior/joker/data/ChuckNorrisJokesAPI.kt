package co.aladinjunior.joker.data

import co.aladinjunior.joker.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChuckNorrisJokesAPI {

    @GET("jokes/random?categories={category}")
    fun getJokes(
        @Query("apiKey")apiKey: String = HTTPClient.API_KEY,
        @Query("category")category: String
    ) : Call<Joke>
}