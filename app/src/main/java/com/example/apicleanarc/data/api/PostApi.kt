package com.example.apicleanarc.data.api

import android.telecom.Call
import com.example.apicleanarc.data.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}