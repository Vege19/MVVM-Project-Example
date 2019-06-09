package com.github.mvvmprojectexample.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.mvvmprojectexample.Model.Movie

@Database(entities = arrayOf(Movie::class), version = 1)
abstract class MyDataBase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}