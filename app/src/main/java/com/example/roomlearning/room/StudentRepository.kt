package com.example.roomlearning.room

class StudentRepository(private val stdDao: StudentDao) {

    val readData = stdDao.readStudentData()

    fun addData(student: Student){
        stdDao.addStudentData(student)
    }

    fun updateData(student: Student){
        stdDao.updateStudentData(student)
    }

    fun deleteData(sId: String?){
        stdDao.deleteStudentData(sId)
    }
}