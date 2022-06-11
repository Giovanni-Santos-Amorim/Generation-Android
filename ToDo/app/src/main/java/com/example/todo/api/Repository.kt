package com.example.todo.api

import com.example.todo.model.Category
import retrofit2.Response

class Repository {

    suspend fun listCategory(): Response<List<Category>>{
        return RetrofitInstance.api.listCategory()
    }
}