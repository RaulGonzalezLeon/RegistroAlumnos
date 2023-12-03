package com.example.registroalumnos.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface alumnoDAO {
    @Insert
    fun addAlumno(alumno: dataAlumno):Long


    @Query("SELECT * FROM alumnos WHERE nombre LIKE :nombre")
    fun obteneralumnopornombre(nombre:String): dataAlumno

    @Update
    fun updateLista(alumno: dataAlumno): Int

    @Delete
    fun deleteLista(alumno: dataAlumno): Int
}