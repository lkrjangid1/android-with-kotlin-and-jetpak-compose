package com.example.coroutines_android

class SuspendDemo {
    private fun firstFunction() {
        println("First function")
    }

    private suspend fun secondFunction() {
        println("Second function")
    }
}