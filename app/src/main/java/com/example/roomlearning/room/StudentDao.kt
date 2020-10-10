package com.example.roomlearning.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    fun addStudentData(student: Student)

    @Update
    fun updateStudentData(student: Student)

    @Query("DELETE FROM students_table where std_id = :sId")
    fun deleteStudentData(sId: String?)

    @Query("SELECT * FROM students_table")
    fun readStudentData() : LiveData<List<Student>>
}