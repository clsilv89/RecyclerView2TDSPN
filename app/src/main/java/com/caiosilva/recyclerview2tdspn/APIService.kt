package com.caiosilva.recyclerview2tdspn

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/photos")
    fun getPhotos(): Call<List<Photo>>

    @POST("/posts")
    fun sendPost(@Body sendPost: SendPost): Call<Post>
}