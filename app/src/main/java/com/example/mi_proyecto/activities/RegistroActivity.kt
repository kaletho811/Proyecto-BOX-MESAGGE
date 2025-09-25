package com.example.mi_proyecto.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mi_proyecto.R

class RegistroActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sharedPreferences = getSharedPreferences("RegistroPrefs", MODE_PRIVATE)
    }
    private fun setupOnClickListener() {
        val etNombres = findViewById<EditText>(R.id.Campo_nom)
        val etApellidos = findViewById<EditText>(R.id.Campo_apell)
        val etCorreo = findViewById<EditText>(R.id.campo_correo)
        val etTelefono = findViewById<EditText>(R.id.campo_tel)
        val etContrasena = findViewById<EditText>(R.id.campo_contr)
        val etConfirmarContrasena = findViewById<EditText>(R.id.campo_contr2)
        val btnRegistrar = findViewById<Button>(R.id.btn_regis)

        btnRegistrar.setOnClickListener {
            val nombres = etNombres.text.toString()
            val apellidos = etApellidos.text.toString()
            val correo = etCorreo.text.toString()
            val telefono = etTelefono.text.toString()
            val contrasena = etContrasena.text.toString()
        }
    }
    private fun validarCampos(nombres: String, apellidos: String, correo: String, telefono: String, contrasena: String, confirmarContrasena: String): Boolean {
        if(nombres.isEmpty()){
            Toast.makeText(this, "Por favor ingrese su nombre", Toast.LENGTH_SHORT).show()
            return false
        }
        if(apellidos.isEmpty()){
            Toast.makeText(this, "Por favor ingrese su apellido", Toast.LENGTH_SHORT).show()
            return false
        }
        if(correo.isEmpty()){
            Toast.makeText(this, "Por favor ingrese su correo", Toast.LENGTH_SHORT).show()
            return false
        }
        if(telefono.isEmpty()){
            Toast.makeText(this, "Por favor ingrese su telefono", Toast.LENGTH_SHORT).show()
            return false
        }
        if(contrasena.isEmpty()){
            Toast.makeText(this, "Por favor ingrese su contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
        if(confirmarContrasena.isEmpty()){
            Toast.makeText(this, "Por favor confirme su contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
        return true

    }

    private fun guardarDatosRegistro(nombres: String, apellidos: String, correo: String, telefono: String, contrasena: String) {
        val editor = sharedPreferences.edit()
        editor.putString("nombres", nombres)
        editor.putString("apellidos", apellidos)
        editor.putString("correo", correo)
        editor.putString("telefono", telefono)
        editor.putString("contrasena", contrasena)
        editor.apply()

    }
}