package com.joduma.prueba.activities.api

import com.joduma.prueba.activities.routes.UsersRoutes

class ApiRoutes {
    val API_URL = "https://www.slyventshop.com/api/"
    val retrofit = RetrofitClient()

    fun getUsersRoutes(): UsersRoutes {
        return retrofit.getCliente(API_URL).create(UsersRoutes::class.java)
    }
}