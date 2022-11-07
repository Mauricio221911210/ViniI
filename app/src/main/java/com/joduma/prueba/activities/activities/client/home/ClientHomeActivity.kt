package com.joduma.prueba.activities.activities.client.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.joduma.prueba.R
import com.joduma.prueba.activities.models.User
import com.joduma.prueba.activities.utils.SharedPref

class ClientHomeActivity : AppCompatActivity() {

    private val TAG = "ClientHomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_home)

        getUserFromSession()

    }

    private fun getUserFromSession(){

        val sharedPref = SharedPref(this)
        val gson = Gson()

        if(!sharedPref.getData("user").isNullOrBlank()){
            // Si el usuario existe en sesion
            val user = gson.fromJson(sharedPref.getData("user"), User::class.java)
            Log.d(TAG, "Usuario: $user")
        }

    }




}