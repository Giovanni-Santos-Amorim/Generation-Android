package com.example.todo.api

import com.example.todo.model.Category
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("category")
    suspend fun listCategory(): Response<List<Category>>
}