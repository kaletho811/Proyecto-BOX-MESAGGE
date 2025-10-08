package com.example.mi_proyecto.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mi_proyecto.activities.MainActivity
import com.example.mi_proyecto.R
import com.example.mi_proyecto.activities.RegistroActivity
import fragments.MiPerfilFragment1

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
        val etEmail = findViewById<EditText>(R.id.correoInicio)
        val etPassword = findViewById<EditText>(R.id.contraseñaInicio)
        val btnLogin = findViewById<Button>(R.id.btn_ingresar)

        btnLogin.setOnClickListener {
            comparacionLogin(etEmail,etPassword)
        }
    }

    private fun comparacionLogin (etEmail: EditText, etPassword: EditText){
        val emailIngresado = etEmail.text.toString().trim()
        val passwordIngresada = etPassword.text.toString().trim()
        val sharedpreferences = getSharedPreferences("RegistroPrefs", MODE_PRIVATE)
        val savedEmail = sharedpreferences.getString("correo", "")
        val savedPassword = sharedpreferences.getString("contrasena", "")

        if (emailIngresado == savedEmail && passwordIngresada == savedPassword ){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
        }
    }
}