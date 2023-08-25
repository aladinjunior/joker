package co.aladinjunior.joker.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

object HTTPClient {

    const val API_KEY = "454207e4-a780-4ba1-968a-cc22f29d3eae"
    private const val BASE_URL = "https://api.tiagoaguiar.co/jokerapp/"

    private fun httpClient() : OkHttpClient{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    fun retrofit() : Retrofit{

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient())
            .build()

    }
}