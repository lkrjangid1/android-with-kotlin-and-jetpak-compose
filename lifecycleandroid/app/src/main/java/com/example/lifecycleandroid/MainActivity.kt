package com.example.lifecycleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import com.example.lifecycleandroid.ui.main.MainFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
            lifecycleScope.launch {
                delay(5000)
                findViewById<ProgressBar>(R.id.progressBar).visibility = ProgressBar.VISIBLE
                delay(10000)
                findViewById<ProgressBar>(R.id.progressBar).visibility = ProgressBar.GONE
            }
        }
    }
}