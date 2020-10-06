package com.example.roomlearning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomlearning.room.Student
import kotlinx.android.synthetic.main.custom_recycler.view.*

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    var itemList = emptyList<Student>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_recycler, null))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList.get(position)

        holder.itemView.txtId.text = currentItem.sId.toString()
        holder.itemView.txtName.text = currentItem.sName
        holder.itemView.txtAddress.text = currentItem.sAddress

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun readData(student: List<Student>){
        this.itemList = student
        notifyDataSetChanged()
    }
}