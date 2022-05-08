package com.example.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val fruits = listOf(Fruit("Apple", "tom"), Fruit("Banana", "ye"), Fruit("Cherry", "lo"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdaptor(fruits,{selectedFruitItem: Fruit -> listItemClicked(selectedFruitItem)})
    }

    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(this, "You clicked on ${fruit.name}", Toast.LENGTH_SHORT).show()
    }
}