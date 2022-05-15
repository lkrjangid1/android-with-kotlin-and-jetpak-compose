package com.example.viewmodalscopeandroid.modal

import kotlinx.coroutines.delay

class UserRepo {
    suspend fun getUsers(): List<User> {
        delay(8000)
        return listOf(
            User(
                1,
                "Doe",
            ),
            User(
                2,
                "John",
            ),
            User(
                3,
                "Jane",
            ),
            User(
                4,
                "Jack",
            )
        )
    }
}