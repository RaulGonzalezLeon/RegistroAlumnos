package com.example.registroalumnos.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(dataAlumno::class), version = 1)
abstract class miAlumnoDB : RoomDatabase() {
    abstract fun alumnoDAO(): alumnoDAO
}