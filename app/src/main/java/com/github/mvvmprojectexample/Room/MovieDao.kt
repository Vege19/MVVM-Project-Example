package com.github.mvvmprojectexample.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.mvvmprojectexample.Model.Movie

@Dao
interface MovieDao {

    //Get all movies
    @Query("SELECT * FROM movie")
    fun getAll(): List<Movie>

    //Insert a movie
    @Insert
    fun insert(movie: Movie)

}