package com.github.mvvmprojectexample.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.github.mvvmprojectexample.R
import com.github.mvvmprojectexample.ViewModel.MovieViewModel

class MovieFragmentView: Fragment() {

    //Inflate the fragment view
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.view_fragment_movie, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Creating ViewModel
        val viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

    }

}