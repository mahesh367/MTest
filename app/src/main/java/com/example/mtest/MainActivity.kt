package com.example.mtest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.room.Room
import com.example.mtest.data.Student
import com.example.mtest.data.StudentDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    private lateinit var database:StudentDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database= Room.databaseBuilder(applicationContext,StudentDatabase::class.java,"studentDB").build()

        GlobalScope.launch {
            database.studentDao().insertStudent(Student(0, "Tushar", 20))
        }

        database.studentDao().getAllStudent().observe(this ,{
                Log.d("RoomDB","Oncreate: $it")
        })
    }
}

