package com.example.onehundred.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiServiceFactory {
    companion object {
        private const val BASE_URL: String = "http://lovinmybag.beetleware.com/"
        fun getInstance(): ApiService {
            val client =

                OkHttpClient.Builder()
                    .connectTimeout(3, TimeUnit.MINUTES)
                    .writeTimeout(3, TimeUnit.MINUTES)
                    .readTimeout(3, TimeUnit.MINUTES).build()



            return Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(ApiService::class.java)
        }
    }
}