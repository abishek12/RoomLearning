package com.example.roomlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.roomlearning.room.Student
import com.example.roomlearning.room.StudentViewModel
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity() {

    lateinit var updateAddress: String
    lateinit var updateName: String
    lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        supportActionBar?.title = "Update Student"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                StudentViewModel::class.java
            )

//        get and set data
        val id = getIntent().getStringExtra("id")
        edtUpdateId.setText(id)
        edtUpdateName.setText(intent.getStringExtra("name"))
        edtUpdateAddress.setText(intent.getStringExtra("address"))

        edtUpdateId.isEnabled = false

    }

    fun updateButton(view: View) {
        val id = getIntent().getStringExtra("id")
        val uId = id?.toInt()
        updateName = edtUpdateName.text.toString()
        updateAddress = edtUpdateAddress.text.toString()

        val std = Student(uId!!, updateName, updateAddress)
        viewModel.updateStdData(std)

        Toast.makeText(this,"Updated Data of $updateName",Toast.LENGTH_LONG).show()
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    fun deleteButton(view: View) {
        val id = getIntent().getStringExtra("id")

        val dialog = AlertDialog.Builder(this)
        dialog.setPositiveButton("Yes"){_,_, ->
            viewModel.deleteStdData(id)
            Toast.makeText(this,"User Deleted",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        dialog.setNegativeButton("No"){_,_, ->}
        dialog.setTitle("Delete Message")
        dialog.setMessage("Are your sure you want to delete?")
        dialog.create().show()
    }
}