package com.joduma.prueba.activities.routes

import com.joduma.prueba.activities.models.ResponseHttp
import com.joduma.prueba.activities.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UsersRoutes {
    @POST( "users" )
    fun  register(@Body user: User): Call<ResponseHttp>
}