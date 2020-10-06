package com.example.roomlearning.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun stdDao() : StudentDao

    companion object{
        fun getWindow(application: Application) : StudentDatabase{
            return Room.databaseBuilder(application,StudentDatabase::class.java,"schoolDb")
                .build()
        }
    }
}