package com.github.mvvmprojectexample.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.github.mvvmprojectexample.Model.Movie
import com.github.mvvmprojectexample.R
import com.github.mvvmprojectexample.Room.MyDataBase
import com.github.mvvmprojectexample.Utils.DynamicAdapter
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieViewModel(application: Application): AndroidViewModel(application) {

    //Get db instance
    private val movieDB: MyDataBase? = MyDataBase.getInstance(application)
    //Live data
    private val allMovies = MutableLiveData<List<Movie>>()

    //Store data
    fun storeMovie(title: String) {
        val movie = Movie()
        movie.name = title
        movieDB?.movieDao()?.insert(movie)
    }

    //Fetch movies from data base using Live Data
    fun retrieveMovies(): LiveData<List<Movie>> {
        GlobalScope.launch {
            val list = movieDB?.movieDao()?.getAll() //Save list of movies in this var
            allMovies.postValue(list)
        }
        return allMovies //Return movies
    }

}