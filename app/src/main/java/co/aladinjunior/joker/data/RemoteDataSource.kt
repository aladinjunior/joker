package co.aladinjunior.joker.data

import co.aladinjunior.joker.model.Category
import co.aladinjunior.joker.model.Joke
import co.aladinjunior.joker.view.JokeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.NullPointerException


class RemoteDataSource {

    fun getCategoryList(categoryListCallback: CategoryListCallback) {
        HTTPClient.retrofit()
            .create(ChuckNorrisCategoriesAPI::class.java)
            .getCategories()
            .enqueue(object : retrofit2.Callback<List<String>>{
                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
                ) {
                    if (response.isSuccessful){
                        val categories = response.body()
                        categoryListCallback.onSuccess(categories ?: emptyList())
                        categoryListCallback.onComplete()
                    } else {
                        val error = response.errorBody()?.string()
                        categoryListCallback.onError(error ?: "Erro desconhecido")
                        categoryListCallback.onComplete()
                    }
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    categoryListCallback.onError(t.message ?: "Erro interno")
                    categoryListCallback.onComplete()
                }

            })

    }

    fun getJokes(jokeCallback: JokeCallback,
                 categoryName: String = JokeFragment.CATEGORY_KEY) {
        HTTPClient.retrofit()
            .create(ChuckNorrisJokesAPI::class.java)
            .getJokes(category = categoryName)
            .enqueue(object : Callback<Joke>{
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if(response.isSuccessful){
                        val joke = response.body()
                        jokeCallback.onSuccess(joke ?:
                        throw NullPointerException("piada não pode ser nula!"))
                        jokeCallback.onComplete()
                    } else {
                        val error = response.errorBody()?.string()
                        jokeCallback.onError(error ?: "Erro desconhecido")
                    }
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    jokeCallback.onError(t.message ?: "Erro interno")
                    jokeCallback.onComplete()
                }

            })
    }
}