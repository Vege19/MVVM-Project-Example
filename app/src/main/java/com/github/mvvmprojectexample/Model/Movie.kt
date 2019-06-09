package com.github.mvvmprojectexample.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo val name: String = ""
)