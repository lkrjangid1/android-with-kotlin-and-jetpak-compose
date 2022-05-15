package com.example.viewmodalscopeandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModal: MainActivityViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModal = ViewModelProvider(this)[MainActivityViewModal::class.java]
        /*mainActivityViewModal.getUserData()*/
        mainActivityViewModal.users.observe(this) {
            it.forEach{
                println(it.name)
            }
        }
    }
}