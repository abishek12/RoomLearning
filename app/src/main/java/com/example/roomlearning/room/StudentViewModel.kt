package com.example.roomlearning.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    val readStdData : LiveData<List<Student>>
    private val repo : StudentRepository

    init {
        val dao = StudentDatabase.getWindow(application).stdDao()
        repo = StudentRepository(dao)
        readStdData = repo.readData
    }

    fun addStdData(student: Student){
        viewModelScope.launch(Dispatchers.IO) {
            repo.addData(student)
        }
    }



}