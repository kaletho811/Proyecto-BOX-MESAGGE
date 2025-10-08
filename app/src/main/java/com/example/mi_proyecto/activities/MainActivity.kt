package com.example.mi_proyecto.activities

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.mi_proyecto.R
import com.google.android.material.navigation.NavigationView
import fragments.MiPerfilFragment1

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.main)
        val btnMenu: ImageView = findViewById(R.id.btn_menu)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)

        ViewCompat.setOnApplyWindowInsetsListener(drawerLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnMenu.setOnClickListener {
            // Abre el cajón lateral
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Cierra el menú al seleccionar un ítem
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener when (menuItem.itemId) {

                // CORRECCIÓN: Usa el ID exacto de tu menú
                R.id.mi_perfil -> {
                    // Cargar el fragmento de Mi Perfil en el contenedor
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MiPerfilFragment1())
                        .commit()
                    true
                }
                R.id.menu_home -> {
                    // Aquí iría el código para cargar tu fragmento de inicio (HomeFragment)
                    // Por ahora, solo devuelve true para manejar el clic
                    true
                }
                else -> false
            }
        }
    }
}