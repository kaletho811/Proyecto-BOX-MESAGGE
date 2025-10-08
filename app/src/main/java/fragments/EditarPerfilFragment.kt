package fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mi_proyecto.R

class EditarPerfilFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var etNombre: EditText
    private lateinit var etApellido: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etCorreo: EditText

    companion object {
        private const val PREFS_NAME = "RegistroPrefs"
        private const val KEY_NOMBRE = "nombres"
        private const val KEY_APELLIDO = "apellidos"
        private const val KEY_TELEFONO = "telefono"
        private const val KEY_CORREO = "correo"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Asegúrate de que el layout cargado sea el correcto (fragment_editar_perfil.xml o el que uses)
        val view = inflater.inflate(R.layout.fragment_editar_perfil, container, false)

        sharedPreferences = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        initViews(view)
        loadCurrentData()
        setupSaveButton(view)

        return view
    }

    private fun initViews(view: View) {
        etNombre = view.findViewById(R.id.edit_nom)
        etApellido = view.findViewById(R.id.edit_apellido)
        etTelefono = view.findViewById(R.id.edit_telef)
        etCorreo = view.findViewById(R.id.edit_correo)
    }

    private fun loadCurrentData() {
        // Carga los datos actuales del perfil para mostrarlos en los EditTexts
        etNombre.setText(sharedPreferences.getString(KEY_NOMBRE, ""))
        etApellido.setText(sharedPreferences.getString(KEY_APELLIDO, ""))
        etTelefono.setText(sharedPreferences.getString(KEY_TELEFONO, ""))
        etCorreo.setText(sharedPreferences.getString(KEY_CORREO, ""))
    }

    private fun setupSaveButton(view: View) {
        val btnGuardar: Button = view.findViewById(R.id.button) // El ID de tu botón "guadar_cambios"

        btnGuardar.setOnClickListener {
            saveChanges()
        }
    }

    private fun saveChanges() {
        val nuevoNombre = etNombre.text.toString().trim()
        val nuevoApellido = etApellido.text.toString().trim()
        val nuevoTelefono = etTelefono.text.toString().trim()
        val nuevoCorreo = etCorreo.text.toString().trim()

        if (nuevoNombre.isEmpty() || nuevoCorreo.isEmpty()) {
            Toast.makeText(requireContext(), "El nombre y correo no pueden estar vacíos.", Toast.LENGTH_SHORT).show()
            return
        }

        // 1. Guardar los nuevos datos en SharedPreferences
        val editor = sharedPreferences.edit()
        editor.putString(KEY_NOMBRE, nuevoNombre)
        editor.putString(KEY_APELLIDO, nuevoApellido)
        editor.putString(KEY_TELEFONO, nuevoTelefono)
        editor.putString(KEY_CORREO, nuevoCorreo)
        editor.apply()

        // 2. Volver al Fragmento de Perfil (removiendo este fragmento)
        Toast.makeText(requireContext(), "¡Cambios guardados con éxito!", Toast.LENGTH_SHORT).show()
        parentFragmentManager.popBackStack() // Esto regresa al fragmento anterior
    }
}
