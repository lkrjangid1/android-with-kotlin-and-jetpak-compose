package com.example.coroutines_android

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.btnCount).setOnClickListener {
            findViewById<TextView>(R.id.tvCount).text = count++.toString()
        }
        findViewById<TextView>(R.id.btnDownloadUserData).setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            withContext(Dispatchers.Main) {
                findViewById<TextView>(R.id.tvUserMessage).text =
                    "Downloading user $i in ${Thread.currentThread().name}"
            }
        }
    }
}