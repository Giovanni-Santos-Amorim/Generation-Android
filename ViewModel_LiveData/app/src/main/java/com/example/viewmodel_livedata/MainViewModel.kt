package com.example.viewmodel_livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel()
{
    var count = MutableLiveData<Int>(0)

    fun add()
    {
        count.value = count.value?.plus(1)
    }

}