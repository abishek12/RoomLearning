package com.example.roomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomlearning.room.Student
import com.example.roomlearning.room.StudentViewModel
import kotlinx.android.synthetic.main.alert_add.view.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: StudentViewModel
    lateinit var customAdapter: CustomAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                StudentViewModel::class.java
            )
        //        display user information
        displayInfo()
    }

    //    when add floating action button is clicked
    fun addMethod(view: View) {
        val dialog = AlertDialog.Builder(this)
        val vview = LayoutInflater.from(this).inflate(R.layout.alert_add, null)
        dialog.setView(vview)
        addStdMethod(vview)
        dialog.show()
    }

    //    display user information
    private fun displayInfo() {
        recyclerView = findViewById(R.id.recyclerview)
        customAdapter = CustomAdapter()
        recyclerView.adapter = customAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.readStdData.observe(this, Observer { students ->
            customAdapter.readData(students)
        })
    }

    //    add student into database
    private fun addStdMethod(view: View) {
        view.addButton.setOnClickListener {
            val name = view.edtAddName.text.toString()
            val address = view.edtAddAddress.text.toString()

            if (TextUtils.isEmpty(name)) {
                view.edtAddName.error = "Required Field ..."
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(address)) {
                view.edtAddAddress.error = "Required Field ..."
                return@setOnClickListener
            }

            val student = Student(0, name, address)
            viewModel.addStdData(student)
            view.edtAddName.setText("")
            view.edtAddAddress.setText("")
            Toast.makeText(application, "Inserted", Toast.LENGTH_LONG).show()

        }
    }
}