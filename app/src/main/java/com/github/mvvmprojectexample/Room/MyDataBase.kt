package com.github.mvvmprojectexample.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.mvvmprojectexample.Model.Movie

@Database(entities = arrayOf(Movie::class), version = 1)
abstract class MyDataBase: RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        private var instance: MyDataBase? = null

        //To instance the db
        fun getInstance(context: Context): MyDataBase? {
            if (instance == null) {
                synchronized(MyDataBase::class) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        MyDataBase::class.java,
                        "movie_db")
                        .build()
                }
            }
            return instance
        }

        //To destroy instance
        fun destroyInstance() {
            instance = null
        }

    }

}