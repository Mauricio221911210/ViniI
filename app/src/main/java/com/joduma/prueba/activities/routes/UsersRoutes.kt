package com.joduma.prueba.activities.routes

import com.joduma.prueba.activities.models.ResponseHttp
import com.joduma.prueba.activities.models.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface UsersRoutes {
    @POST( "users" )
    fun  register(@Body user: User): Call<ResponseHttp>


    @FormUrlEncoded
    @POST( "api/login" )
    fun login(@Field("username") username: String, @Field("password") password: String): Call<ResponseHttp>

    @Multipart
    @PUT("users/update")
    fun update (
        @Part image: MultipartBody.Part,
        @Part("user") user: RequestBody

    ): Call<ResponseHttp>

}