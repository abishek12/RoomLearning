package com.example.roomlearning

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomlearning.room.Student

class CustomAdapter(var context: Context) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    var itemList = emptyList<Student>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName : TextView ?= itemView.findViewById(R.id.txtName)
        val txtAddress : TextView ?= itemView.findViewById(R.id.txtAddress)
        val txtId : TextView ?= itemView.findViewById(R.id.txtId)
        val imgEdit : CardView ?= itemView.findViewById(R.id.cardViewUpdate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_recycler, null)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList.get(position)
        holder.txtId?.text = currentItem.sId.toString()
        holder.txtName?.text = currentItem.sName
        holder.txtAddress?.text = currentItem.sAddress

        holder.imgEdit?.setOnClickListener {
            val intent = Intent(context, UpdateActivity::class.java)

            intent.putExtra("id",currentItem.sId.toString())
            intent.putExtra("name",currentItem.sName)
            intent.putExtra("address",currentItem.sAddress)

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun readData(student: List<Student>) {
        this.itemList = student
        notifyDataSetChanged()
    }
}