package com.github.mvvmprojectexample.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mvvmprojectexample.R
import com.github.mvvmprojectexample.Utils.DynamicAdapter
import com.github.mvvmprojectexample.ViewModel.MovieViewModel
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlinx.android.synthetic.main.view_fragment_movie.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieFragmentView: Fragment() {

    //Inflate the fragment view
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.view_fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //RecyclerView layout manager setup
        moviesRecyclerView.layoutManager = GridLayoutManager(context, 1)

        //Creating ViewModel
        val viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        //On click function for Insert Button
        insertButton.setOnClickListener {
            insertTitle(viewModel)
            retrieveMovies(viewModel)
        }

        retrieveMovies(viewModel)

    }

    //Function to get title from edit text
    private fun insertTitle(viewModel: MovieViewModel) {
        //My edit text
        val input = insertMovieTitle.text.toString().trim()

        //Validation edit text
        if (input.isEmpty()) {
            insertMovieTitle.setError("Title is required", resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            return
        }

        //Save the movie
        GlobalScope.launch {
            viewModel.storeMovie(input)
        }

        Toast.makeText(activity, "$input entered.", Toast.LENGTH_SHORT).show()

    }

    private fun retrieveMovies(viewModel: MovieViewModel) {
        //Fetch the movies and observe it
        viewModel.retrieveMovies().observe(this, Observer {
            if (it.isNotEmpty()) {
                moviesRecyclerView.adapter = DynamicAdapter(R.layout.item_movie, it, fun (_, view, movie, _) {
                    view.movieTitle.text = movie.name
                })
            } else {
                Log.d("debug", "No data available.")
            }
        })
    }

}