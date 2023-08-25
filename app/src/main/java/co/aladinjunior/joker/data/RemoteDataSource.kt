package co.aladinjunior.joker.data

import android.os.Handler
import android.os.Looper
import co.aladinjunior.joker.model.Category
import retrofit2.Call
import retrofit2.Response


class RemoteDataSource {

    fun fakeRequest(callback: Callback) {
        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .getCategories()
            .enqueue(object : retrofit2.Callback<List<String>>{
                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
                ) {
                    if (response.isSuccessful){
                        val categories = response.body()
                        callback.onSuccess(categories ?: emptyList())
                        callback.onComplete()
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Erro desconhecido")
                        callback.onComplete()
                    }
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    callback.onComplete()
                }

            })

    }
}