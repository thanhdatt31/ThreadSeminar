package com.example.threadseminar.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"
        var retrofit: Retrofit? = null
        val photo: Retrofit
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit!!
            }

    }
}