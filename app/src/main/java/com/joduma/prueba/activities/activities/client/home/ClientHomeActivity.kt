package com.joduma.prueba.activities.activities.client.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.gson.Gson
import com.joduma.prueba.R
import com.joduma.prueba.activities.MainActivity
import com.joduma.prueba.activities.models.User
import com.joduma.prueba.activities.utils.SharedPref

class ClientHomeActivity : AppCompatActivity() {

    private val TAG = "ClientHomeActivity"
    var buttonLogout: Button? = null
    var sharedPref: SharedPref? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_home)
        sharedPref = SharedPref(this)

        buttonLogout = findViewById(R.id.btn_logout)
        buttonLogout?.setOnClickListener {  logout() }


        getUserFromSession()

    }


    private fun logout(){
        sharedPref?.remove("user")
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }

    private fun getUserFromSession(){


        val gson = Gson()

        if(!sharedPref?.getData("user").isNullOrBlank()){
            // Si el usuario existe en sesion
            val user = gson.fromJson(sharedPref?.getData("user"), User::class.java)
            Log.d(TAG, "Usuario: $user")
        }

    }




}