package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdaptor(val fruits : List<Fruit>, private val clickListener:(Fruit)->Unit): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val listItem = LayoutInflater.from(parent.context).inflate(R.layout.list_tile, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruits[position], clickListener)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit) {
        view.findViewById<TextView>(R.id.name_textView).text = fruit.name
        view.setOnClickListener {
            clickListener(fruit)
        }
    }
}