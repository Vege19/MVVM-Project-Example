package com.github.mvvmprojectexample.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mvvmprojectexample.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set fragment
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, MovieFragmentView()).commit()

    }
}
