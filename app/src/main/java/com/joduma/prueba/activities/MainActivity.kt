package com.joduma.prueba.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.gson.Gson
import com.joduma.prueba.R
import com.joduma.prueba.activities.activities.client.home.ClientHomeActivity
import com.joduma.prueba.activities.models.ResponseHttp
import com.joduma.prueba.activities.models.User
import com.joduma.prueba.activities.providers.UsersProvider
import com.joduma.prueba.activities.utils.SharedPref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var imageViewGoToRegister: ImageView? = null
    var editTextEmail: EditText? = null
    var editTextUsername: EditText? = null
    var editTextPassword: EditText? = null
    var buttonLogin: Button? = null
    var usersProvider = UsersProvider()


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

            usersProvider.login(username, password)?.enqueue(object : Callback <ResponseHttp>{
                override fun onResponse(call: Call<ResponseHttp>, response: Response<ResponseHttp>
                ) {
                    Log.d("MainActivity", "Response: ${response.body()}")

                    if (response.body()?.issuccess == true){
                        Toast.makeText(this@MainActivity, response.body()?.message, Toast.LENGTH_LONG).show()
                        saveUserInSession(response.body()?.data.toString())
                        goToClientHome()
                    }
                    else {
                        Toast.makeText( this@MainActivity, "Los datos no son correctos", Toast.LENGTH_LONG).show()
                    }


                }

                override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                    Log.d("MainActivity", "Hubo un error ${t.message}")
                    Toast.makeText(this@MainActivity, "Hubo un error ${t.message}",Toast.LENGTH_LONG).show()

                }

            })

            /*Toast.makeText(this, "El formulario es valido", Toast.LENGTH_LONG).show()*/
        }
        else {
            Toast.makeText(this, "No es valido", Toast.LENGTH_LONG).show()
        }

       /* Log.d("MainActivity", "El username es: $username")
        Log.d("MainActivity", "El password es: $password")*/
    }

    private fun goToClientHome(){
        val i = Intent(this, ClientHomeActivity::class.java)
        startActivity(i)
    }


    private fun saveUserInSession(data: String) {
        val sharedPref = SharedPref(this)
        val gson = Gson()
        val user = gson.fromJson(data, User::class.java )
        sharedPref.save("user", user)

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