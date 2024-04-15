package com.example.login_test_app

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("auth/register")
    fun register(@Body user: User): Call<ResponseBody>

    @POST("auth/login")
    fun login(@Body credentials: LoginCredentials): Call<LoginResponse>

    @GET("profile/profileDetails")
    fun getUserDetails(@Header("authorization") token: String): Call<UserDetails>
}
