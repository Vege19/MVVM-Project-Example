package com.github.mvvmprojectexample.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.github.mvvmprojectexample.R
import com.github.mvvmprojectexample.ViewModel.MovieViewModel
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

        //Creating ViewModel
        val viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        //On click function for Insert Button
        insertButton.setOnClickListener {
            insertTitle(viewModel)
        }

    }

    //Function to get title from edit text
    private fun insertTitle(viewModel: MovieViewModel) {
        //My edit text
        val input = insertMovieTitle.text.toString().trim()

        if (input.isEmpty()) {
            insertMovieTitle.setError("Title is required", resources.getDrawable(R.drawable.ic_error_outline_black_24dp))
            return
        }

        GlobalScope.launch {
            viewModel.storeMovie(input)
        }
        
        Toast.makeText(activity, "$input entered.", Toast.LENGTH_SHORT).show()

    }

}