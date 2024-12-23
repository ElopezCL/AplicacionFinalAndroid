package com.example.aplicacionfinal.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aplicacionfinal.data.local.dao.MovieDao
import com.example.aplicacionfinal.data.local.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {


    abstract fun movieDao(): MovieDao
}
