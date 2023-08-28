package co.aladinjunior.joker.data

import co.aladinjunior.joker.model.Joke
import co.aladinjunior.joker.view.JokeFragment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun getCategories(@Query("apiKey")apiKey: String = HTTPClient.API_KEY) : Call<List<String>>


    //full url: https://api.tiagoaguiar.co/jokerapp/jokes/random?category=food&apiKey=454207e4-a780-4ba1-968a-cc22f29d3eae

    @GET("jokes/random?")
    fun getJokes(
        @Query("apiKey")apiKey: String = HTTPClient.API_KEY,
        @Query("category")category: String
    ) : Call<Joke>

    @GET("jokes/random")
    fun getJokeDay(
        @Query("apiKey")apiKey: String = HTTPClient.API_KEY
    )
}