package com.example.mtest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val age:Int
)
