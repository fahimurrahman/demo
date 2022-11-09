package com.example.testappformvvm.di

import com.example.testappformvvm.helper.Constants
import com.example.testappformvvm.helper.Constants.BASE_URL
import com.example.testappformvvm.repository.retrofit.APIServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun httpClient() = OkHttpClient.Builder().addInterceptor { chain ->
        val request: Request = chain.request()
        val builder: Request.Builder = request.newBuilder()
            .addHeader("Authorization", Constants.AUTH_TOKEN)
            .method(request.method, request.body)
        val request1: Request = builder.build()
        chain.proceed(request1)
    }.build()



    @Provides
    @Singleton
    fun provideRetrofitInstance():APIServices =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient())
            .build()
            .create(APIServices::class.java)
}