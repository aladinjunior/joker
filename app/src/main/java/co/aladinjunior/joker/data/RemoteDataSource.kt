package co.aladinjunior.joker.data

import android.os.Handler
import android.os.Looper
import co.aladinjunior.joker.model.Category


class RemoteDataSource {

    fun fakeRequest(callback: Callback) {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val response = listOf(
                "Category 1",
                "Category 2",
                "Category 3",
                "Category 4"
            )
            callback.onSuccess(response)
            callback.onComplete()
        }, 2000)
    }
}