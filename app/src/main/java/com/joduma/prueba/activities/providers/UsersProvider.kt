package com.joduma.prueba.activities.providers

import com.joduma.prueba.activities.api.ApiRoutes
import com.joduma.prueba.activities.models.ResponseHttp
import com.joduma.prueba.activities.models.User
import com.joduma.prueba.activities.routes.UsersRoutes
import retrofit2.Call

class UsersProvider {
    private var usersRoutes: UsersRoutes? = null




    init {
        val  api = ApiRoutes()
        usersRoutes = api.getUsersRoutes()
    }

    fun register(user: User): Call<ResponseHttp>? {
        return usersRoutes?.register(user)
    }

    fun login(username: String, password: String): Call<ResponseHttp>? {
        return usersRoutes?.login(username, password)
    }






}