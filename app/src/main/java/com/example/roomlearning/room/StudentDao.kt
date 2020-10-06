package com.example.roomlearning.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    fun addStudentData(student: Student)

    @Query("SELECT * FROM students_table")
    fun readStudentData() : LiveData<List<Student>>
}