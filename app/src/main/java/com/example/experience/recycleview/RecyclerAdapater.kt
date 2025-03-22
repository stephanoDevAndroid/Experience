package com.example.experience.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.experience.ClearDomain.UserModel
import com.example.experience.R

class RecyclerAdapater(val list: List<UserModel>): RecyclerView.Adapter<RecyclerAdapater.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.name)
        val lastName = view.findViewById<TextView>(R.id.lastName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.lastName.text = list[position].lastName
    }
}