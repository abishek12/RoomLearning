package com.example.roomlearning.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "std_id")
    var sId: Int,
    @ColumnInfo(name = "std_name")
    var sName: String,
    @ColumnInfo(name = "std_address")
    var sAddress: String
)