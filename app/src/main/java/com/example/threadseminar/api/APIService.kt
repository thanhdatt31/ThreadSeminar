package com.example.threadseminar.api

import com.example.threadseminar.PhotoItem
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("photos")
    fun getPhotoList() : Call<List<PhotoItem>>
}