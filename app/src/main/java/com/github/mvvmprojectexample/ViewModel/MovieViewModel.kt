package com.github.mvvmprojectexample.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.mvvmprojectexample.Model.Movie
import com.github.mvvmprojectexample.Room.MyDataBase

class MovieViewModel(application: Application): AndroidViewModel(application) {

    //Get db instance
    private val movieDB: MyDataBase? = MyDataBase.getInstance(application)

    //Store data
    fun storeMovie(title: String) {
        val movie = Movie()
        movie.name = title
        movieDB?.movieDao()?.insert(movie)
    }

}