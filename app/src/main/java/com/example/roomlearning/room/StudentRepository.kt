package com.example.roomlearning.room

class StudentRepository(private val stdDao: StudentDao) {

    val readData = stdDao.readStudentData()

    fun addData(student: Student){
        stdDao.addStudentData(student)
    }
}