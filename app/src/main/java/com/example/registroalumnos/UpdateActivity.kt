package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.database.dataAlumno
import com.example.registroalumnos.database.miAlumnoDB
import com.example.registroalumnos.databinding.ActivityMainBinding
import com.example.registroalumnos.databinding.ActivityUpdateBinding
import com.example.registroalumnos.mdatabase.miAlumno
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateActivity : ActivityWithMenus() {
    lateinit var binding : ActivityUpdateBinding
    lateinit var listaAlumnos: MutableList<dataAlumno>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonActualizar.setOnClickListener(){

            var nombreAlumno = binding.actualizarNombre.text.toString()
            var cursoAlumno = binding.actualizarCurso.text.toString()


            // Validaciones
            if (nombreAlumno.isEmpty())
            {
                Toast.makeText(this, "No puede haber campos vacíos", Toast.LENGTH_SHORT).show()
            }
            else
            {

                updateAlumno(nombreAlumno, cursoAlumno)
                Toast.makeText(this, "Alumno eliminado", Toast.LENGTH_SHORT).show()




            }
        }
    }

    fun updateAlumno(alumno: String, curso:String){
        CoroutineScope(Dispatchers.IO).launch{
            val alumno = miAlumno.database.alumnoDAO().obteneralumnopornombre(alumno)

            val listaAlumnos = alumno[0]
            listaAlumnos.curso = curso
            miAlumno.database.alumnoDAO().updateLista(listaAlumnos)


        }
    }
}