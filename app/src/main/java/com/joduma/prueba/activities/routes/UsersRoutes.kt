package com.joduma.prueba.activities.routes

import com.joduma.prueba.activities.models.ResponseHttp
import com.joduma.prueba.activities.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsersRoutes {
    @POST( "users" )
    fun  register(@Body user: User): Call<ResponseHttp>


    @FormUrlEncoded
    @POST( "api/login" )
    fun login(@Field("username") username: String, @Field("password") password: String): Call<ResponseHttp>


}