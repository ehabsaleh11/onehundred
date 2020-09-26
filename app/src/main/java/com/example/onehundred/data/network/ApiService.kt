package com.example.onehundred.data.network

import com.example.onehundred.data.entity.employee.EMPLOYEE
import com.example.onehundred.data.entity.item.ITEM
import com.example.onehundred.data.entity.user.Profile
import com.example.onehundred.data.entity.user.USER
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("api/auth")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Observable<USER>

    @GET("api/sold-items")
    fun sold_item_count(@Header("Authorization")authHeader: String ): Observable<ITEM>

    @GET("api/products")
    fun product_count(@Header("Authorization")authHeader: String ): Observable<ITEM>

    @GET("api/employee-statistics")
    fun employee_statistics(@Header("Authorization")authHeader: String ): Observable<EMPLOYEE>

    @GET("api/profile-show")
    fun profile_show(@Header("Authorization")authHeader: String ): Observable<Profile>

}