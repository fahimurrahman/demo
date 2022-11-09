package com.example.testappformvvm.repository.retrofit

import com.example.testappformvvm.helper.Constants
import com.example.testappformvvm.repository.model.ExampleData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIServices {

    @GET(Constants.END_PONT)
    suspend fun getDatas(@Query("customerId") customerId:Int) : Response<ExampleData>
}