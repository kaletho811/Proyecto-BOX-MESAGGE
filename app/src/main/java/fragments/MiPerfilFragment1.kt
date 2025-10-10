package fragments

import android.R.attr.mode
import android.R.attr.name
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mi_proyecto.R

class MiPerfilFragment1 : Fragment(){
    private lateinit var Nom_perfil: TextView
    private lateinit var Ape_perfil : TextView
    private lateinit var Tel_perfil: TextView
    private lateinit var Corr_perfil : TextView
    private lateinit var sharedPreferences : SharedPreferences

    private lateinit var progressBar: ProgressBar

    companion object{
        private const val PREFS_NAME = "RegistroPrefs"
        private const val KEY_NOMBRE = "nombres"
        private const val KEY_APELLIDO = "apellidos"
        private const val KEY_TELEFONO = "telefono"
        private const val KEY_CORREO = "correo"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mi_perfil1, container, false)
        initViews(view)
        setUpSharedPreferences()
        setupEditButton(view)
        return view
    }

    override fun onResume() {
        super.onResume()
        loadUserData()
    }

    private fun setupEditButton(view: View) {
        val btnEditar: Button = view.findViewById(R.id.btn_edi_perf)
        btnEditar.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EditarPerfilFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun loadUserData(){
        progressBar.visibility = View.VISIBLE
        Nom_perfil.visibility = View.INVISIBLE
        Ape_perfil.visibility = View.INVISIBLE

        val nombre = sharedPreferences.getString(KEY_NOMBRE, "")
        val apellido = sharedPreferences.getString(KEY_APELLIDO, "")

        Nom_perfil.text = nombre
        Ape_perfil.text = apellido

        progressBar.visibility = View.GONE
        Nom_perfil.visibility = View.VISIBLE
        Ape_perfil.visibility = View.VISIBLE
    }

    private fun setUpSharedPreferences(){
        sharedPreferences = requireActivity().getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE)

    }

    private fun initViews(view: View){
        Nom_perfil = view.findViewById(R.id.Nom_perfil)
        Ape_perfil = view.findViewById(R.id.Ape_perfil)
        Tel_perfil = view.findViewById(R.id.Tel_perfil)
        Corr_perfil = view.findViewById(R.id.Corr_perfil)

        progressBar = view.findViewById(R.id.progress_bar)
    }
}