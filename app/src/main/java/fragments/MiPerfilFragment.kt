package fragments

import android.R.attr.mode
import android.R.attr.name
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mi_proyecto.R

class MiPerfilFragment : Fragment(){
    private lateinit var tvNombre: TextView
    private lateinit var tvApellido : TextView
    private lateinit var tvCorreo : TextView
    private lateinit var tvTelefono : TextView
    private lateinit var sharedPreferences : SharedPreferences

    companion object{
        private const val PREFS_NAME = "userData"
        private const val KEY_NOMBRE = "user_nombre"
        private const val KEY_APELLIDO = "user_apellido"
        private const val KEY_CORREO = "user_correo"
        private const val KEY_TELEFONO = "user_telefono"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_profile, container, false)

        initViews(view)
    }

    private fun loadUserData(){
        val nombre = sharedPreferences.getString(KEY_NOMBRE, "")
        val apellido = sharedPreferences.getString(KEY_APELLIDO, "")
        val correo = sharedPreferences.getString(KEY_CORREO, "")
        val telefono = sharedPreferences.getString(KEY_TELEFONO, "")

    }

    private fun setUpSharedPreferences(){
        sharedPreferences = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        name = PREFS_NAME,
        mode = Context.MODE_PRIVATE
    }

    private fun initViews(view: View){
        tvNombre=view.findViewById(R.id.Nom_perfil)
        tvApellido=view.findViewById(R.id.Ape_perfil)
        tvCorreo=view.findViewById(R.id.Corr_perfil)
        tvTelefono=view.findViewById(R.id.Tel_perfil)

    }
}