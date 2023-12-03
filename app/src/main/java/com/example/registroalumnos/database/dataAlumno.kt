package com.example.registroalumnos.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alumnos")
data class dataAlumno(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var nombre:String = "",
    var apellido:String = "",
    var curso:String = ""
)
