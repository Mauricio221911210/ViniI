package com.joduma.prueba.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.joduma.prueba.R
import com.joduma.prueba.activities.models.ResponseHttp
import com.joduma.prueba.activities.models.User
import com.joduma.prueba.activities.providers.UsersProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    val  TAG = "RegisterActivity"

    var imageViewGoToLogin: ImageView? = null
    var editTextName: EditText? = null
    var editTextLastName: EditText? = null
    var editTextUsername: EditText? = null
    var editTextEmail: EditText? = null
    var editTextPassword: EditText? = null
    var buttonRegister: Button? = null

    var usersProvider = UsersProvider()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        imageViewGoToLogin = findViewById(R.id.imageview_go_to_login)
        editTextName = findViewById(R.id.edittext_name)
        editTextLastName = findViewById(R.id.edittext_lastname)
        editTextUsername = findViewById(R.id.edittext_username)
        editTextEmail = findViewById(R.id.edittext_email)
        editTextPassword = findViewById(R.id.edittext_password)
        buttonRegister = findViewById(R.id.btn_register)



        imageViewGoToLogin = findViewById(R.id.imageview_go_to_login)
        imageViewGoToLogin?.setOnClickListener{ goToLogin() }
        buttonRegister?.setOnClickListener { register() }



    }

    private fun register(){
        val name = editTextName?.text.toString()
        val lastname = editTextLastName?.text.toString()
        val username = editTextUsername?.text.toString()
        val email = editTextEmail?.text.toString()
        val password = editTextPassword?.text.toString()

        if (isValidForm(name = name, lastname = lastname, username = username  ,email = email, password = password)) {

            val user = User(
                name = name,
                lastname = lastname,
                username = username,
                email = email,
                password = password,
            )

            usersProvider.register(user)?.enqueue(object: Callback<ResponseHttp> {
                override fun onResponse(Call: Call<ResponseHttp>, response: Response<ResponseHttp>) {

                    Toast.makeText( this@RegisterActivity, response.message(), Toast.LENGTH_LONG).show()


                    Log.d(TAG, "Response: ${response}" )
                    Log.d(TAG, "Body: ${response.body()}" )
                }

                override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                    Log.d(TAG, "Se produjo un error ${t.message}")
                    Toast.makeText( this@RegisterActivity,"Se produjo un error ${t.message}", Toast.LENGTH_LONG).show()
                }

            })
        }





    }

    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun isValidForm(
        name: String,
        lastname: String,
        username: String,
        email: String,
        password: String,
    ): Boolean {

        if (name.isBlank()) {
            Toast.makeText(this, "Debes ingresar el nombre", Toast.LENGTH_SHORT).show()
            return false
        }

        if (lastname.isBlank()) {
            Toast.makeText(this, "Debes ingresar el apellido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (username.isBlank()) {
            Toast.makeText(this,"Debes ingresar el username", Toast.LENGTH_SHORT).show()
            return false
        }



        if (email.isBlank()) {
            Toast.makeText(this, "Debes ingresar el email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.isBlank()) {
            Toast.makeText(this, "Debes ingresar el contraseña", Toast.LENGTH_SHORT).show()
            return false
        }


        if (!email.isEmailValid()) {
            Toast.makeText(this, "El email no es valido", Toast.LENGTH_SHORT).show()
            return false
        }


        return true
    }


    private fun goToLogin (){
        val i = Intent( this, MainActivity::class.java )
        startActivity(i)
    }

}


