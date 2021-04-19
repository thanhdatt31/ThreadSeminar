package com.example.threadseminar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.threadseminar.api.APIService
import com.example.threadseminar.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadPhotos()
    }

    private fun loadPhotos() {
        val apiServices = RetrofitClient.photo.create(APIService::class.java)
        val call = apiServices.getPhotoList()
        call.enqueue(object : Callback<List<PhotoItem>> {
            override fun onFailure(call: Call<List<PhotoItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<List<PhotoItem>>,
                response: Response<List<PhotoItem>>
            ) {
                val listPhoto: List<PhotoItem> = response.body()!!
                val photo = listPhoto[0].title
                Log.d("datnt", "onResponse: $photo")
            }

        })
    }
}