package com.example.registroalumnos

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.registroalumnos.database.dataAlumno
import com.example.registroalumnos.databinding.ActivityMainBinding
import com.example.registroalumnos.mdatabase.miAlumno
import com.example.registroalumnos.mdatabase.miAlumno.Companion.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenus() {

    lateinit var binding : ActivityMainBinding
    lateinit var listaAlumnos: MutableList<dataAlumno>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaAlumnos = ArrayList()

        binding.bAnadir.setOnClickListener{




                // Creamos el alumno
                var alumno = dataAlumno(nombre = binding.escribirNombre.text.toString(), apellido = binding.escribirApellido.text.toString(), curso = binding.escribirCurso.text.toString())

                // Añadimos el alumno a la lista

                listaAlumnos.add(alumno)
                // Añadimos el alumno a la base de datos
                anadirAlumno(alumno)
                // muestro un mensaje de que se ha añadido el alumno
                Toast.makeText(this, "Alumno añadido", Toast.LENGTH_SHORT).show()

                // Limpiamos los campos
                clearFocus()

                // Cerramos el teclado
                cerrarTeclado()

        }
    }
    fun anadirAlumno(alumno: dataAlumno) {
        CoroutineScope(Dispatchers.IO).launch {
            database.alumnoDAO().addAlumno(alumno)
        }
    }
    fun cerrarTeclado() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
    fun clearFocus(){
        binding.escribirNombre.setText("")
        binding.escribirApellido.setText("")
        binding.escribirCurso.setText("")

    }


}