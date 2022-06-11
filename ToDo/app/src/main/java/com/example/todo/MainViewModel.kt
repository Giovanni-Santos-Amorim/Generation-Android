package com.example.todo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.api.Repository
import com.example.todo.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val repository: Repository
        ):ViewModel() {

    private val _MyCategoryResponse =
        MutableLiveData<Response<List<Category>>>()

    val myCategoryResponse: LiveData<Response<List<Category>>> =
        _MyCategoryResponse

    init {
        listCategory()
    }

    fun listCategory(){
        viewModelScope.launch {
            try{

                val response = repository.listCategory()

                _MyCategoryResponse.value = response

            }catch (e: Exception){
                Log.d("Error", e.message.toString())
            }
        }

    }
}