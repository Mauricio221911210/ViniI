package com.joduma.prueba.activities.models

import com.google.gson.annotations.SerializedName

class User (
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("email_verified") val email_verified_at: String? = null,
    @SerializedName("role_id") val role_id: String? = null,
    @SerializedName("password") val password: String,
    @SerializedName("remember_token") val remember_token: String? = null,



    ) {

        override fun toString(): String {
            return "User(id='$id', name='$name', lastanme='$lastname', username='$username', email='$email',email_verified_at='$email_verified_at',role_id='$role_id', password='$password', remember_token='$remember_token')"
        }
}