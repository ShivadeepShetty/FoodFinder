package com.app.foodfinder.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.app.foodfinder.data.DataRepository

public class HomeViewModel @ViewModelInject constructor(private val repository: DataRepository) : ViewModel() {


    private val currentQuery = MutableLiveData("")

    /**
     * start searching when user enters the text
     */
    val foodData = currentQuery.switchMap {it->
        repository.getSearchData(it)
    }



    fun searchData(query:String?){
        currentQuery.value = query
    }

    fun dispose(){
        repository.dispose()
    }
}