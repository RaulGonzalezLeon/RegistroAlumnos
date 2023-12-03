package com.example.registroalumnos

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.registroalumnos.database.dataAlumno
import com.example.registroalumnos.databinding.ActivityDeleteBinding
import com.example.registroalumnos.databinding.ActivityUpdateBinding
import com.example.registroalumnos.mdatabase.miAlumno.Companion.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteActivity : ActivityWithMenus() {

    private lateinit var binding : DeleteActivity
    private lateinit var listaAlumnos: MutableList<dataAlumno>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonEliminar.setOnClickListener(){

            var nombreAlumno = binding.eliminarNombre.text.toString()


            // Validaciones
            if (nombreAlumno.isEmpty())
            {
                Toast.makeText(this, "No puede haber campos vacíos", Toast.LENGTH_SHORT).show()
            }
            else
            {
                var alumno = dataAlumno(nombre = nombreAlumno)

                eliminarAlumno(alumno)
                Toast.makeText(this, "Alumno eliminado", Toast.LENGTH_SHORT).show()




            }
        }
    }

    fun eliminarAlumno(nombreAlumno: dataAlumno){
        CoroutineScope(Dispatchers.IO).launch {
            database.alumnoDAO().obteneralumnopornombre(nombreAlumno.nombre)
        }
    }




}