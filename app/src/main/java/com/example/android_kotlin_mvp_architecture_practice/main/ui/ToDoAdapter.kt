package com.example.android_kotlin_mvp_architecture_practice.main.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_mvp_architecture_practice.R

class ToDoAdapter(private val dataSet: List<String>) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_to_do_item, parent, false))
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    class ToDoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val toDoDescriptionTextView: TextView = view.findViewById<TextView>(R.id.to_do_description)

        fun bind(text: String) {
            toDoDescriptionTextView.text = text
        }
    }
}