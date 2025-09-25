package com.example.mi_proyecto.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mi_proyecto.activities.MainActivity
import com.example.mi_proyecto.R
import com.example.mi_proyecto.activities.RegistroActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val startRegister = findViewById<TextView>(R.id.link_registrar)
        startRegister.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
        val etEmail = findViewById<TextView>(R.id.correoInicio)
        val etPassword = findViewById<TextView>(R.id.contraseñaInicio)
        val btnLogin = findViewById<TextView>(R.id.btn_ingresar)

        btnLogin.setOnClickListener {
            comparacionLogin(etEmail,etPassword)
        }
    }

    private fun comparacionLogin (etEmail: EditText, etPassword: EditText){
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val sharedpreferences = getSharedPreferences("userData", MODE_PRIVATE)
        val savedEmail = sharedpreferences.getString(email, "")
        val savedPassword = sharedpreferences.getString(password, "")
        if (email == savedEmail && password == savedPassword ){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "credenciales incorrectas", Toast.LENGTH_SHORT).show()
        }
    }
}