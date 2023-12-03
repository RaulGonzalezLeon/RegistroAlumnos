package com.example.registroalumnos.mdatabase

import android.app.Application
import androidx.room.Room
import com.example.registroalumnos.database.miAlumnoDB

class miAlumno: Application() {

    companion object{
        lateinit var database: miAlumnoDB
    }

    override fun onCreate(){
        super.onCreate()
        miAlumno.database = Room.databaseBuilder(this, miAlumnoDB::class.java, "miAlumnoDB").build()
    }

}