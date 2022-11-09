package com.example.testappformvvm.repository

import com.example.testappformvvm.repository.retrofit.APIServices
import javax.inject.Inject

class ExampleDataRepo

@Inject
constructor(private val apiServices: APIServices){
    suspend fun getListData(a:Int) = apiServices.getDatas(a)
}
