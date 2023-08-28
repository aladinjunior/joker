package co.aladinjunior.joker.data

import co.aladinjunior.joker.model.Joke
import co.aladinjunior.joker.view.JokeFragment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun getCategories(@Query("apiKey")apiKey: String = HTTPClient.API_KEY) : Call<List<String>>


    @GET("jokes/random?")
    fun getJokes(
        @Query("apiKey")apiKey: String = HTTPClient.API_KEY,
        @Query("category")category: String
    ) : Call<Joke>
}