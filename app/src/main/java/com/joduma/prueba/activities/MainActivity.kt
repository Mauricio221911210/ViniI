package com.joduma.prueba.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.joduma.prueba.R

class MainActivity : AppCompatActivity() {

    var imageViewGoToRegister: ImageView? = null
    var editTextEmail: EditText? = null
    var editTextUsername: EditText? = null
    var editTextPassword: EditText? = null
    var buttonLogin: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewGoToRegister = findViewById(R.id.imageview_got_to_register)
        editTextEmail = findViewById(R.id.edittext_email)
        editTextUsername = findViewById(R.id.edittext_username)
        editTextPassword = findViewById(R.id.edittext_password)
        buttonLogin = findViewById(R.id.btn_login)



        imageViewGoToRegister = findViewById(R.id.imageview_got_to_register)
        imageViewGoToRegister?.setOnClickListener { goToRegister() }
        buttonLogin?.setOnClickListener { login() }
    }

    private fun login() {
        val username = editTextUsername?.text.toString() // NULL POINTER EXCEPTION
        val password = editTextPassword?.text.toString()

        if (isValidForm(username, password)) {
            Toast.makeText(this, "El formulario es valido", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, "No es valido", Toast.LENGTH_LONG).show()
        }

        Log.d("MainActivity", "El username es: $username")
        Log.d("MainActivity", "El password es: $password")
    }

    // fun String.isUsernameValid(): Boolean {
    //   return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    //}

    private fun isValidForm(username: String, password: String): Boolean {

        if (username.isBlank()) {
            return false
        }

        if (password.isBlank()) {
            return false
        }

        /* if (!username.isUsernameValid()) {
             return false
         }*/

        return true
    }

    private fun goToRegister (){
        val l = Intent(this, RegisterActivity::class.java)
        startActivity(l)
    }


}