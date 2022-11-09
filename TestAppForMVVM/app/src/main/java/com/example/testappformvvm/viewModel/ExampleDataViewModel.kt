package com.example.testappformvvm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testappformvvm.repository.ExampleDataRepo
import com.example.testappformvvm.repository.model.ExampleData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExampleDataViewModel
@Inject
constructor(private val repo: ExampleDataRepo) : ViewModel(){
    private val _response = MutableLiveData<ExampleData>()
    val responser: LiveData<ExampleData>
        get() = _response

//    init {
//        getAllData(108)
//    }

    fun getAllData(i: Int) = viewModelScope.launch {
        repo.getListData(i).let { response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("getAllData", "wrong")
            }
        }
    }
}